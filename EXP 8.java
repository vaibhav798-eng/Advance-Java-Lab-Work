Import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class hello extends HttpServlet {
private static final long serialVersionUID = 1L;
public void doGet(HttpServletRequest request, HttpServletResponse
response) throws ServletException, IOException {
PrintWriter out=response.getWriter(); java.util.Date today=new
java.util.Date(); out.println("<html>"+"<body>"+"<h1
align=center>welcome to
exciting world of servlet</h1>"+"<br>"+today+"</body>"+"</html>");
}
}
