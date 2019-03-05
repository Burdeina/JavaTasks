package com.company;


import java.util.Scanner;

public class Main {
    public static void First()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("First part");
        System.out.println("Please enter n and m");
        int sum=0;
        int n,m;
        n=scan.nextInt();
        m=scan.nextInt();
        int [][] MatrixSum=new int[n][m];
        int [][] arr=new int[n][m];
        int[] vec=new int[n];
        for(int i=0;i<n;i++)
        {
            vec[i]=0;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                MatrixSum[i][j]=1;
                arr[i][j]=(int)(Math.random()*100);
            }

        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        int temp=0;
        for(int i=0;i<n;i++)
        {

            for(int j=0;j<m;j++)
            {
                sum=0;
                temp=arr[i][j];
                while(temp != 0){

                    sum += (temp % 10);
                    temp/=10;
                }
                MatrixSum[i][j]=sum;

            }
        }

        //System.out.println(sum+" ");
        System.out.println("Matrix Sum:");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print(MatrixSum[i][j] + " ");
            }
            System.out.println();
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(MatrixSum[i][j]>=vec[i]){
                    vec[i]=MatrixSum[i][j];
                }
            }
        }
        System.out.println("Vector:");
        for(int i=0;i<n;i++)
        {
            System.out.print(vec[i]+" ");
        }


    }
    public static void Second(String str){
        str = str.replaceAll("t", "th");
        String[] arr;
        arr = str.split(",");
        for (int i=0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static void Sort(BaseEducation arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j].yearOfFoundation > arr[j+1].yearOfFoundation)
                {

                    BaseEducation temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
    public static void Third(BaseEducation[] arr){
        System.out.println("Subtask 1:");
        Sort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.println( arr[i].Name + " " + arr[i].yearOfFoundation);
        }

        System.out.println("Subtask 2:");
        School minStud = new School();
        int countOfSchools = 0, j = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] instanceof School){
                countOfSchools++;
            }
        }
        School[] schools = new School[countOfSchools];
        for (int i = 0; i < arr.length; i++){
            if(arr[i] instanceof School){
                schools[j] = (School)arr[i];
                j++;
            }
        }
        minStud = schools[0];
        for (int i = 1; i < schools.length; i++){
            if(schools[i].countOfStudents < minStud.countOfStudents){
                minStud = schools[i];
            }
        }
        System.out.println(minStud.Name + " "+ minStud.countOfStudents);


        System.out.println("Subtask 3:");

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter accreditation level: ");
        int a = sc.nextInt();

        int countOfUniversities = 0, m = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] instanceof University){
                countOfUniversities++;

            }
        }
        University[] universities = new University[countOfUniversities];
        for (int i = 0; i < arr.length; i++){
            if(arr[i] instanceof University){
                universities[m] = (University)arr[i];
                m++;
            }
        }
        System.out.println("Name of university with "+a+" accreditation level:");
        for (int i = 0; i < universities.length; i++){
            if(universities[i].accreditationLevel == a){
                System.out.println(universities[i].Name);
            }
        }

    }

    public static void main(String[] args) {

        //First();
        //Second("mother,tom,track,tag,tera");

        BaseEducation [] arr = new BaseEducation[7];
        for(int i=0;i<3;i++)
        {
            arr[i]=new School("SZH"+i,"Mazepe23"+i,1990-2*i,30+i,(int)(Math.random()*1000));
        }
        for(int i=0;i<4;i++)
        {
            arr[i+3]=new University("LNU"+i,"Universitecka1"+i,1661+30*i,i+1,(int)(Math.random()*30));
        }


        Third(arr);


    }
}
