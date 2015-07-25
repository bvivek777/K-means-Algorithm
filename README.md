# K-means-Algorithm
java implemetation of the k means algorithm
The K means algorithm is used to group the similar data points into clusters 
which allow for efficient data mining tasks to be performed. But there are several 
drawbacks to this algorithm.
This project allows the implemetation of the k means algorithm taking inout from
a text or data file. The file path has to be provided as arguement for the main 
function. The input format is such that <br>
-> The first line contains the number of cluster centers<br> 
-> depending upon the number of cluster centers the input with the number of dimensions 
   have to be provided by the user. All th data points should hava the same number of
   dimensions.<br>
->The dimensions in the input file have to be given by providing space between, make sure that
  there is no space left after the final dimension is entered<br>
  Eg: 23 12 45<br>
  the above is an example for a 3 dimensional data point.<br>
->The execution of the program in command prompt should be of the form<br>
  javac Main.java<br>
  java Main "input file path"<br>
->The argument can be directly assigned in the eclipse IDE
