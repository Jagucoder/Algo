#compile path should be root path, both for package and it's invoker.
#packge declaration in binSearch then can use packageName.className to run.

javac mytool/Stdin.java;

javac binSearch/BinarySearch.java;
java  binSearch.BinarySearch algs4-data/largeW.txt < algs4-data/largeT.txt
