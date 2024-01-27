# WIP (WORK IN PROGRESS) 

<p align="center">
  <img width="500px" src="https://github.com/AlejandroDavidArzolaSaavedra/TP/assets/90756437/d6a87239-4d19-4c9a-9dbe-fc49d809833b">
</p>

<h1 align="center">Concurrent Text File Statistics 📊📄</h1>

The objective of this activity is to practice the use of Concurrent Programming features in Java.

### Assignment 📝
Develop a Java system that concurrently processes sets of text files. The goal of the system is to process a given set of files, analyze them, and obtain a list of the 10 most frequent words, sorted by frequency in descending order.

### Processing Most Frequent Words 🔄

#### General Structure 🏗️
The text files to be processed, containing plain text, are located in the 'data' directory of the current user's HOME directory.

The system performs the following actions:

1. Identifies the set of files to be processed (already implemented in `Tools.fileLocator()`) and stores their names in an object of the `FileNames` class.
2. Multiple threads of the `FileReader` class sequentially retrieve file names from a `FileNames` object and read the corresponding files, adding their content to an object of the `FileContents` class.
3. Multiple threads of the `FileProcessor` class sequentially read the content of the files from a `FileContents` object, process it by separating words and counting their frequency, updating the result on a common "counter" in the `WordFrequencies` class.
4. The top 10 most frequent words are sorted and selected based on a `WordFrequencies` object (implemented in `Tools.wordSelector()`).

<p align="center">
  <img width="500px" src="https://github.com/AlejandroDavidArzolaSaavedra/TP/assets/90756437/5d0097b6-a3c1-460c-88ac-865dbc4772d7">
</p>

To build the system, different classes representing various processes and data containers handled by the system must be created. The following classes need to be maintained with the provided interface:

### Class: `FileNames`
An object of this class temporarily stores the names of the files to be processed. The `Tools.fileLocator()` method is responsible for adding file names, and `FileReader` threads handle consuming them. The `FileNames` object has a method to indicate when its function is complete, ceasing to accept more file names, and not making the requesting thread wait for more names.

#### Methods
- `void addName(String fileName)`: Stores a new file name in the object.
- `String getName()`: Extracts and returns a file name from the object. When no files are available, the requesting thread must wait for the situation to change unless `noMoreNames()` has been called, in which case null is immediately returned. Therefore, null indicates that no more file names will be returned.
- `void noMoreNames()`: Causes the object to no longer accept more file names.

### Class: `FileContents`
An object of this class is responsible for storing and supplying strings, each containing all the textual information from one of the files. The number of strings, as well as their total size, are limited at the time of the object's construction. `FileReader` threads will add data to the object, and `FileProcessor` threads will remove them. The object has a mechanism to know when it stops being functional, wherein `FileReader` threads indicate when they start and finish producing content. The object becomes non-functional when there are no more `FileReader` threads and no content to return.

#### Methods
- `FileContents(int maxFiles, int maxChars)`: Initializes by setting the maximum number of files that can be stored and the maximum total size of the strings that can be stored at any given time.
- `void registerWriter()`: Called to indicate that a new `FileReader` is using the object.
- `void unregisterWriter()`: Indicates that a `FileReader` has stopped producing content. When the number of registered `FileReader` drops from 1 to 0, the object will no longer receive more content.
- `void addContents(String contents)`: Called by `FileReader` thread to add the content of a file. If the limit of files or the maximum set for the total content size is reached, the thread waits until the situation changes. The maximum content size limit does not apply if there is no stored content.
- `String getContents()`: Called by `FileProcessor` thread to extract the content of a file. If no content is available, the thread waits until there is, unless the last `FileReader` has unregistered, in which case null is immediately returned.

### Class: `FileReader`
A thread that iteratively obtains a file name from a `FileNames`, reads its content, and stores it in a `FileContents`. It terminates if `FileNames` returns null. To facilitate the implementation of this class, the `Tools.getContents(String fname)` method is provided, which, when given a file name, returns its content.

#### Methods
- `FileReader(FileNames fn, FileContents fc)`: Initializes an object by setting the `FileName` and `FileContents` it will use in its execution.

### Class: `FileProcessor`
A thread that iteratively reads the content of a file from `FileContents` and processes it (separates and counts its different words), storing the result in a `WordFrequencies`. It terminates if `FileContents` returns null. A word is defined as a contiguous sequence of alphanumeric characters (in the Spanish language), delimited by a space, symbol, or end of the file.

#### Methods
- `FileProcessor(FileContents fc, WordFrequencies wf)`: Initializes an object by setting the `FileContents` and `WordFrequencies` it will use in its execution.

### Class: `WordFrequencies`
An object of this class will store the found words and their corresponding accumulated frequencies for the set of processed files.

#### Methods
- `void addFrequencies(Map<String,Integer> f)`: Adds the passed word/frequency information to the current object.
- `HashMap<String,Integer> getFrequencies()`: Returns the accumulated word/frequency pairs.

### Main: `Main.main`
The main program must be completed to create 2 `FileReader` threads and 3 `FileProcessor` threads. It should also wait for them to finish so that it can terminate itself.

### The 10 Most Frequent Words and Their Frequencies
The 10 most frequent words and their frequencies in the supplied files are:

1. "de" - 26,658
2. "que" - 20,180
3. "la" - 17,104
4. "y" - 17,093
5. "a" - 13,289
6. "el" - 13,210
7. "en" - 11,587
8. "no" - 7,573
9. "se" - 7,271
10. "los" - 6,994 🚀
