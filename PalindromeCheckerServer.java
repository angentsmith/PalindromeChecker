
import java.net.*;
import java.io.*;
public class PalindromeCheckerServer {
	
	ServerSocket ss;
	Socket socket;
	BufferedReader sock_in,kdb_in;
	PrintWriter sock_out;
	String str;
	    public PalindromeCheckerServer()
	    {
	    try{
	        ss=new ServerSocket(1221);
	        System.out.println("Server is listening port 1221");
	        socket=ss.accept();
	        System.out.println("Now is connection");
	        kdb_in=new BufferedReader(new InputStreamReader(System.in));
	        sock_in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        sock_out=new PrintWriter(socket.getOutputStream());
	        while(true)
	        {
	        System.out.println("Message from client");
	        str=sock_in.readLine();
			str=str.toLowerCase();
	        int k=str.length();
	        System.out.println(str);
	        int left=0,right=k-1;int flag=1;
			char charLeft, charRight;
	        while(left<=right)
	        {
	             charLeft = str.charAt(left);
	            charRight = str.charAt(right);


	            if (charLeft == charRight)
	            {
	                left++;
	                right--;
	            }

	            else if (charLeft == ',' || charLeft == '.' ||
	 charLeft == '-' || charLeft == ':' ||
	 charLeft == ';' || charLeft == ' ')

	                left++;

	            else if (charRight == ',' || charRight == '.' ||
	 charRight == '-' || charRight == ':' ||
	 charRight == ';' || charRight == ' ')
	                right--;
	            else
				{
					flag=0;
				}

	                break;
	        }
	        if(flag==1)
	            str="....It is Palindrome....";
	        else
	            str="....It is Not Palindrome....";
	        //System.out.println("Enter the message");
	        //str=kdb_in.readLine();
	        sock_out.println(str);
	        sock_out.flush();
	        if(str.equals("bye"))
	            break;
	        }
	    }catch (Exception e) { }
	    }
	public static void main(String arg[])
	{
	    new PalindromeCheckerServer();
	}}

