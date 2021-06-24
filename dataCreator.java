import java.io.*;
import java.util.*;
public class dataCreator
{
    String owner,ex,w;int room,days,flour,family,ch=0,r=0,co=0;
    char rr;
    int arr[][];double cost;
    double z=0.0;
    DataInputStream k=new DataInputStream(System.in);
    public void create()throws Exception
    {

        FileReader a0=new FileReader("HOTEL.DAT");
        BufferedReader b0=new BufferedReader(a0);
        FileWriter x0=new FileWriter("temp.DAT");
        BufferedWriter y0=new BufferedWriter(x0);
        PrintWriter p0=new PrintWriter(y0);
        b0.close();
        p0.close();
        File P0=new File("HOTEL.DAT");
        File Q0= new File("temp.DAT");
        P0.delete();
        Q0.renameTo(P0);
        FileWriter a=new FileWriter("HOTEL.DAT",true);
        BufferedWriter b=new BufferedWriter(a);
        PrintWriter p=new PrintWriter(b);
        FileReader a1=new FileReader("HOTEL.DAT");
        BufferedReader b1=new BufferedReader(a1);

        System.out.println("HOTEL NAME");
        String s1=k.readLine();
        System.out.println("enter your hotels floor with room");
        r=Integer.parseInt(k.readLine());
        System.out.println("enter your total no. of room in a floor");
        co=Integer.parseInt(k.readLine());
        System.out.println("cost for one day stay");
        z=Double.parseDouble(k.readLine());
        arr=new int[r][co];
        p.println(r);
        p.println(co);
        p.println(z);
        p.println("\t"+s1);
        p.close();
    }

    public void book()throws Exception
    {

        FileWriter a=new FileWriter("HOTEL.DAT",true);
        BufferedWriter b=new BufferedWriter(a);
        PrintWriter p=new PrintWriter(b);
        FileReader a11=new FileReader("HOTEL.DAT");
        BufferedReader b11=new BufferedReader(a11);
        do{

            System.out.print("Floors vacant = ");

            for(int x=0;x<=r-1;x++)
            {
                int flag=co;
                for(int y=0;y<=co-1;y++)
                {
                    if(arr[x][y]!=0)
                    {
                        flag--;
                        break;
                    }

                }
                if(flag>0)
                    System.out.print((x+1)+" ; ");
            }
            System.out.println();
            System.out.println("\nEnter name under which room has to be booked");
            owner=k.readLine();
            System.out.println("Which floor do u choose");
            flour=Integer.parseInt(k.readLine());

            System.out.println("room vacant on this floor are");
            for(int x=0;x<=co-1;x++)
            {
                if(arr[flour-1][x]==0)
                {
                    if((x+1)<10)
                    {
                        System.out.print(flour+("0")+(x+1));
                    }
                    else
                        System.out.print(flour+""+(x+1));

                    if(x/2<=(flour-1))
                    {
                        System.out.println();
                    }
                }
            }

            System.out.println("\nEnter room no");
            room=Integer.parseInt(k.readLine());
            arr[flour-1][(room%100)-1]=room;
            System.out.println("Total no. of people");
            family=Integer.parseInt(k.readLine());
            System.out.println("No. of day's you wish to spend");
            days=Integer.parseInt(k.readLine());
            System.out.print("Room confirmed on = ");
            Calendar c = new GregorianCalendar();
            System.out.println(c.get(Calendar.DATE)+"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.YEAR)+",time = "+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND));         
            w=c.get(Calendar.DATE)+"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.YEAR)+",time = "+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
            cost=z*(double)days;  
            System.out.println("Total expenditure on room =  "+cost+"\n\n\n");

            p.println(owner);
            p.println(room);
            p.println(days);
            p.println(family);
            p.println(cost);
            p.println(w);
            ex=((int)c.get(Calendar.DATE)+days)+"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.YEAR)+",time = "+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
            p.println(ex);
            System.out.println("Press y to book another room else press any key");
            rr=(k.readLine()).charAt(0) ;
        }
        while(rr=='y');

        p.close();
        System.out.println("\n       YOUR FILE IS SAVED");

    }

    public void printAll()throws Exception
    {
        dataCreator obj=new dataCreator();

        for(int x=0;x<=r-1;x++)
        {
            for(int y=0;y<=co-1;y++)
            {
                if(arr[x][y]!=0)
                    obj.printSelected(arr[x][y]);
            }
        }
    }

    public void printSelected(int r3)throws Exception
    {
        FileReader a=new FileReader("HOTEL.DAT");
        BufferedReader b=new BufferedReader(a);

        String ks=b.readLine();ks=b.readLine();ks=b.readLine();
        String h=b.readLine();
        System.out.println("\t"+h);
        System.out.println(" \t"+"ROOM DETAILS"+"\n");
        while((owner=b.readLine())!=null)
        {
            room=Integer.parseInt(b.readLine());
            days=Integer.parseInt(b.readLine());
            family=Integer.parseInt(b.readLine());
            cost=Double.parseDouble(b.readLine());
            w=b.readLine();
            ex=b.readLine();
            if(room==r)
            {
                System.out.println("NAME OF OWNER = "+owner);
                System.out.println("ROOM NO. = "+room);
                System.out.println("NO. OF DAYS= "+days);
                System.out.println("NO. OF FAMILY MEMBERS = "+family);
                System.out.println("TOTAL EXPENDITURE = "+cost);
                System.out.println("DATE OF ENTRY = "+w);
                System.out.println("ROOM EXPIRY DATE = "+ex);
            }
        }
        b.close();
        System.out.println("\n         SEARCH FINISHED");
    }

    public void Expired()throws Exception
    {
        FileReader a=new FileReader("HOTEL.DAT");
        BufferedReader b=new BufferedReader(a);
        FileWriter x=new FileWriter("temp.DAT");
        BufferedWriter y=new BufferedWriter(x);
        PrintWriter p=new PrintWriter(y);
        String ks=b.readLine();
        p.println(ks);
        ks=b.readLine();
        p.println(ks);
        ks=b.readLine();
        p.println(ks);
        String h=b.readLine();
        p.println(h);
        while((owner=b.readLine())!=null)
        {
            room=Integer.parseInt(b.readLine());
            days=Integer.parseInt(b.readLine());
            family=Integer.parseInt(b.readLine());
            cost=Double.parseDouble(b.readLine());
            w=b.readLine();
            ex=b.readLine();

            Calendar c = new GregorianCalendar();
            String u=c.get(Calendar.DATE)+"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.YEAR)+",time = "+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);         
            if(u.compareTo(ex)<0)
            {
                p.println(owner);
                p.println(room);
                p.println(days);
                p.println(family);
                p.println(cost);
                p.println(w);
                p.println(ex);

            }
        }
        b.close();
        p.close();
        File P=new File("HOTEL.DAT");
        File Q= new File("temp.DAT");
        P.delete();
        Q.renameTo(P);

        System.out.println("       DESIRED CHANGES HAVE BEEN DONE");

    }

    public void edit()throws Exception
    {
        FileReader a=new FileReader("HOTEL.DAT");
        BufferedReader b=new BufferedReader(a);
        FileWriter x=new FileWriter("temp.DAT");
        BufferedWriter y=new BufferedWriter(x);
        PrintWriter p=new PrintWriter(y);
        String ks=b.readLine();
        p.println(ks);
        ks=b.readLine();
        p.println(k);
        ks=b.readLine();
        p.println(ks);
        String h=b.readLine();
        p.println(h);
        while((owner=b.readLine())!=null)
        {
            room=Integer.parseInt(b.readLine());
            days=Integer.parseInt(b.readLine());
            family=Integer.parseInt(b.readLine());
            cost=Double.parseDouble(b.readLine());
            w=b.readLine();
            ex=b.readLine();

            Calendar c = new GregorianCalendar();
            String u=c.get(Calendar.DATE)+"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.YEAR)+",time = "+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);         
            if(u.compareTo(ex)<0)
            {
                p.println(owner);
                p.println(room);
                p.println(days);
                p.println(family);
                p.println(cost);
                p.println(w);
                p.println(ex);

            }
        }
        b.close();
        p.close();
        File P=new File("HOTEL.DAT");
        File Q= new File("temp.DAT");
        P.delete();
        Q.renameTo(P);

        System.out.println("       DESIRED CHANGES HAVE BEEN DONE");

    }
}
