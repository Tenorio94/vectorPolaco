/*
    CalculateGrade.cpp
    We will write a program to get a grade and to display the character
    based on the next criteria

Grade                    Character

>=90                         A

>=80   <90                   B

>= 70  <80                   C

>= 50  < 70                  D

anyother                     E

Marian Muñoz
A00232046
version 1.0
*/

#include <iostream>
#include <math.h>

using namespace std;
/*
    GetGrade
   This is a function to make the Getting of the Grade variables. 
   using the string function to store the Grade in the same string sMessage function.
   Parameters:
   dGrade

   Returns:
   dGrade
   */
 double GetGrade (string sMessage)
 {
     double dGrade;
     cout<< sMessage << endl;
     cin >> dGrade ;
     
     return dGrade;
 }
 /*
    CalculateGrade
   This is a function to make the Calculation of the grade using the variables
   and converting it into Characters (A,B,C,D,E).
   The program gets the Grade in numbers and converts them in characters.
  
   Parameters:
   dGrade
   cGrade

   Returns:
   cGrade
   */
 
 char CalculateGrade(double dGrade)
 {
    char cGrade;
     if (dGrade >= 90)
     {
         cGrade = 'A';
     }
     
     else if ( dGrade >= 80 && dGrade < 90 )
     {
         cGrade = 'B';
     }
     
     else if ( dGrade >= 70 && dGrade < 80 ) 
     {
         cGrade = 'C';
     }
     
     else if ( dGrade >= 50  && dGrade < 70)
     {
        cGrade = 'D';
     }
     
    else
    {
        cGrade = 'E';
    } 
    
    return cGrade;
    
 }
 /*
    Display
    To Display the message of the Calculation of the Grade into the Character
  
   Parameters:
   cGrade

   Returns:
   no returns because is a void
   */
   void Display(double CalculateGrade, char cGrade)
   {
       cout<< CalculateGrade << " = " << cGrade << endl;
       
   }
     /* 
       Main Function
    Gets the Grade, Calculates the Grade into character
    And display the convertion of the character.
    Returns:
    an integer value with the error number (0 = none)
    */
int main()
{
  double dGrade;
  char cGrade;
  
  dGrade = GetGrade("Enter Grade");
  cGrade = CalculateGrade(dGrade);
  
    Display (dGrade, cGrade);
   return 0;
}
