import java.io.*;
public class hotelRoomManager
{
    public void control()throws Exception
    {

        dataCreator o4=new dataCreator();
        DataInputStream k=new DataInputStream(System.in);
        int ch=0;String c;
        while(ch!=6)
        {
            System.out.println("\tMENU");
            Thread.sleep(700);
            System.out.println("PRESS 0 FOR DELETE PREVIOUS DATABASE AND CREATE A NEW ONE");
            Thread.sleep(700);
            System.out.println("PRESS 1 FOR RO0M BOOKING" );
            Thread.sleep(700);
            System.out.println("PRESS 2 FOR PRINTING DETAILS OF EVERY FILLED ROOM");
            Thread.sleep(700);
            System.out.println("PRESS 3 FOR SEARCHING A PARTICULAR ROOM");
            Thread.sleep(700);
            System.out.println("PRESS 4 FOR DELETING RECORDS OF ROOM THAT GOT EXPIRED");
            Thread.sleep(700);
            System.out.println("PRESS 5 FOR EDITIND A PARTICULAR ROOM");
            Thread.sleep(700);
            System.out.println("PRESS 6 TO EXIT\n");
            ch=Integer.parseInt(k.readLine());
            switch(ch)
            {
                case 0: o4.create();
                break;
                case 1:o4.book();
                break;
                case 2:o4.printAll();
                break;
                case 3:int room;
                System.out.println("Enter the room no.");
                room=Integer.parseInt(k.readLine());
                o4.printSelected(room);
                break;
                case 4:o4.Expired();
                break;
                case 5:o4.edit();
                break;
                case 6:System.exit(1);
                break;
               
                default:if(ch!=6&&ch!=0)
                    System.out.println("INVALID CHOICE\n");
            }    
            System.out.println("\t THANK YOU FOR USING \n\tplease press enter to continue\n");
            c=k.readLine();
            
            System.out.println("\f");
        }
    }
}