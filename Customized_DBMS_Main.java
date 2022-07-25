import java.lang.*;
import java.util.*;

class Customized_DBMS_Main
{
    public static void main(String arg[])
    {

        DBMS dobj = new DBMS();
        dobj.StartDBMS();

        Scanner scanobj = new Scanner(System.in);
        String Query = "";

        while(true)
        {
            System.out.print("Stalli's DBMS Console -> ");
            Query = scanobj.nextLine();
            Query = Query.toLowerCase(); 


            String tokens[] = Query.split(" ");
            int QuerySize = tokens.length;

            if( QuerySize == 3 || QuerySize > 5 )
            {
                System.out.println("-----INVALID COMMAND-----");
            }

            if(QuerySize == 1)
            {
                //HELP
                if("help".equals(tokens[0]))
                {
                    System.out.println("'MAN Command_Name' : to give the syntax of above Commands");
                    System.out.println("'SELECT' : to display the whole data");
                    System.out.println("'DELETE': to Delete an Entry from the table");
                    System.out.println("'INSERT': to Insert a New Entry");
                    System.out.println("'TOTAL' : to displaiy the total no. of entries in table");
                    System.out.println("'SUM' : to displaiy sum of Salaries");
                    System.out.println("'MAX' : to displaiy the Maximum Salary");
                    System.out.println("'MIN' : to displaiy the Minimum Salary");
                    System.out.println("'AVG' : to displaiy the Average Salary");
                    System.out.println("'EXIT' : Exit the database");
                }
                //EXIT
                else if("exit".equals(tokens[0]) )
                {
                    System.out.println("<----Thank you for using Stalli's DBMS---->");
                    break;
                }
                else
                {
                    System.out.println("-----INVALID COMMAND-----");
                }
            }
            else if(QuerySize == 2)
            {
                // MAN
                if("man".equals(tokens[0]))
                {
                    //MAN SELECT
                    if("select".equals(tokens[1]))
                    {
                        System.out.println("'SELECT' : to display the whole data");
                        System.out.println("Syntax : SELECT * From Student");
                        System.out.println("'SELECT WHERE' : to display specific entry");
                        System.out.println("Syntax : SELECT WHERE RID = RID_no");
                        System.out.println("Syntax : SELECT WHERE Name = Student_Name");
                    }
                    //MAN DELETE 
                    else if("delete".equals(tokens[1]))
                    {
                        System.out.println("'DELETE': to remove an Entry from the table");
                        System.out.println("Syntax : DELETE WHERE RID = RID_NO");
                        System.out.println("Syntax : DELETE WHERE Name = Student_Name"); 
                    }
                    //MAN INSERT 
                    else if("insert".equals(tokens[1]))
                    {
                        System.out.println("'INSERT': to Insert a New Entry");
                        System.out.println("Syntax : INSERT into Student NAME SALARY ");
                    }
                    //MAN TOTAL
                    else if("total".equals(tokens[1]))
                    {
                        System.out.println("'TOTAL' : to displaiy the total no. of entries in table");
                        System.out.println("Syntax : SELECT TOTAL");
                    }
                    //MAN SUM
                    else if("sum".equals(tokens[1]))
                    {
                        System.out.println("'SUM' : to displaiy sum of Salaries");
                        System.out.println("Syntax : SELECT SUM");
                    }
                    //MAN MAX
                    else if("max".equals(tokens[1]))
                    {
                        System.out.println("'MAX' : to displaiy the Maximum Salary");
                        System.out.println("Syntax : SELECT MAX");
                    }
                    //MAN MIN
                    else if("min".equals(tokens[1]))
                    {
                        System.out.println("'MIN' : to displaiy the Minimum Salary");
                        System.out.println("Syntax : SELECT MIN");
                    }
                    //MAN AVG
                    else if("avg".equals(tokens[1]))
                    {
                        System.out.println("'AVG' : to displaiy the Average Salary");
                        System.out.println("Syntax : SELECT AVG");
                    }
                    else
                    {
                        System.out.println("-----INVALID COMMAND-----");
                    }               
                }
                // Select
                else if( "select".equals(tokens[0]) )
                {
                    // Select TOTAL
                    if("total".equals(tokens[1]))
                    {
                        dobj.AggregateCount();
                    }
                    //Select SUM
                    else if("sum".equals(tokens[1]))
                    {
                        dobj.AggregateSum();
                    }
                    //Select MAX
                    else if("max".equals(tokens[1]))
                    {
                        dobj.AggregateMax();
                    }
                    //Select MIN
                    else if("min".equals(tokens[1]))
                    {
                        dobj.AggregateMin();
                    }
                    //Select AVG
                    else if("avg".equals(tokens[1]))
                    {
                        dobj.AggregateAvg();
                    }
                    else
                    {
                        System.out.println("-----INVALID COMMAND-----");
                    }
                }
                else
                {
                    System.out.println("-----INVALID COMMAND-----");
                } 
            }
            else if(QuerySize == 4)
            {
                // Select * from Student
                if("select".equals(tokens[0]))
                {
                    if( ("*".equals(tokens[1])) && ("from".equals(tokens[2])) && ("student".equals(tokens[3])) )
                    {
                        dobj.DisplayAll();
                    }
                    else
                    {
                        System.out.println("-----INVALID COMMAND-----");
                    }
                }
            }
            else if(QuerySize == 5)
            {
                // Insert into Student Piyush 1000;
                if( ("insert".equals(tokens[0])) && ("into".equals(tokens[1])) && ("student".equals(tokens[2])) )
                {
                    dobj.InsertData(tokens[3],Integer.parseInt(tokens[4]));
                }
                //Select where
                else if( "select".equals(tokens[0]) && ("where".equals(tokens[1])) )
                {
                    //Select where RID = 2
                    if("rid".equals(tokens[2]))
                    {
                        dobj.DisplaySpecific(Integer.parseInt(tokens[4]));
                    }
                    //Select Where Name = Gaurav
                    else if("name".equals(tokens[2]))
                    {
                        dobj.DisplaySpecific(tokens[4]);
                    }
                    else
                    {
                        System.out.println("-----INVALID COMMAND-----");
                    }
                }
                //Delete Where
                else if( "delete".equals(tokens[0]) && ("where".equals(tokens[1])) )
                {
                    // Delete where RID = 2
                    if("rid".equals(tokens[2]))
                    {
                        dobj.DeleteSpecific(Integer.parseInt(tokens[4]));
                    }
                    //Delete Where Name = Gaurav
                    else if("name".equals(tokens[2]))
                    {
                        dobj.DeleteSpecific(tokens[4]);
                    }
                    else
                    {
                        System.out.println("-----INVALID COMMAND-----");
                    }
                }
                else
                {
                    System.out.println("-----INVALID COMMAND-----");
                }
            }
        }

    }
}

class Student
{
    public int RID;
    public String Name;
    public int Salary;

    private static int Generator;

    static              //static block
    {
        Generator = 0;     // private static int Generator = 0;
    }

    public Student(String str,int value)
    {
        this.RID = ++Generator;
        this.Name = str;
        this.Salary = value;
    }

    public void DisplayData()
    {
        System.out.println(this.RID+"\t"+this.Name+"\t"+this.Salary);
    }

}

class DBMS
{
    public LinkedList<Student> lobj;

    public DBMS()
    {
        lobj = new LinkedList<Student>();
    }
    
    public void StartDBMS()
    {
        System.out.println("-> Stalli's Customised DBMS started Successfully <-");
    }

    public void InsertData(String str , int value)
    {
        Student sobj = new Student(str,value);
        lobj.add(sobj);
        System.out.println("Data added Successfully");
    }

    // Display All Data 
    public void DisplayAll()
    {
        System.out.println("RID\tName\tSalary");
        for(Student sref : lobj)
        {
            sref.DisplayData();
        }
    }

    // Display by RID
    public void DisplaySpecific(int rid)
    {
        System.out.println("RID\tName\tSalary");
        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                sref.DisplayData();
                break;
            }
        }
    }

    // Display by Name
    public void DisplaySpecific(String str)         // Overloading by datatype
    {
        System.out.println("RID\tName\tSalary");
        for(Student sref : lobj)
        {
            if(str.equals(sref.Name))    //  (sref.Name).equals(str)
            {
                sref.DisplayData();
            }
        }
    }

    // Delete by RID
    public void DeleteSpecific(int rid)
    {
        int index = 0;
        for(Student sref : lobj)
        {
            if(sref.RID ==  rid)    //  (sref.Name).equals(str)
            {
                lobj.remove(index);
                System.out.println("Data Deleted Successfully");
                break;
            }
            index++;
        }
    }

    // Delete by name
    public void DeleteSpecific(String str)
    {
        //int index = 0;
        for(Student sref : lobj)
        {
            if(str.equals(sref.Name))    //  (sref.Name).equals(str)
            {
                lobj.remove(sref);
                System.out.println("Data Deleted Successfully");
            }
           // index++;
        }
    }

    // Maximum Salary
    public void AggregateMax()
    {
        int iMax = 0;
        Student temp = null;

        for(Student sref : lobj)
        {
            if(sref.Salary > iMax)
            {
                iMax = sref.Salary;
                temp = sref;
            }
        }
        System.out.println("Information of Student having maximum salary: ");
        System.out.println("RID\tName\tSalary");
        temp.DisplayData();
    }

    // Minimum Salary
    public void AggregateMin()
    {
        int iMin = (lobj.getFirst()).Salary;
        Student temp = lobj.getFirst();

        for(Student sref : lobj)
        {
            if(sref.Salary < iMin)
            {
                iMin = sref.Salary;
                temp = sref;
            }
        }
        System.out.println("Information of Student having minimun salary: ");
        System.out.println("RID\tName\tSalary");
        temp.DisplayData();
    }

    // sum of Salaries
    public void AggregateSum()
    {
        long iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Salary;
        }
        System.out.println("Summation of salaries is: "+iSum);
    }

    // Average salary
    public void AggregateAvg()
    {
        long iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Salary;
        }
        System.out.println("Average Salary is: "+(iSum/lobj.size()));
    }
    
    // Total Count of entries
    public void AggregateCount()
    {
        System.out.println("total entries in the table are: "+lobj.size());
    }
}