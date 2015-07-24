# K-means-Algorithm
java implemetation of the k means algorithm
The K means algorithm is used to group the similar data points into clusters 
which allow for efficient data mining tasks to be performed. But there are several 
drawbacks to this algorithm.
This project allows the implemetation of the k means algorithm taking inout from
a text or data file. The file path has to be provided as arguement for the main 
function. The input format is such that 
-> The first line contains the number of cluster centers 
-> depending upon the number of cluster centers the input with the number of dimensions 
   have to be provided by the user. All th data points should hava the same number of
   dimensions.
->The dimensions in the input file have to be given by providing space between, make sure that
  there is no space left after the final dimension is entered
  Eg: 23 12 45
  the above is an example for a 3 dimensional data point.
->The execution of the program in command prompt should be of the form
  javac Main.java
  java Main <input file path>
->The argument can be directly assigned in the eclipse IDE
