import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Gensis on 2016/8/10.
 */
@WebServlet(name="coreservlet",urlPatterns = "/coreservlet")
public class CoreServlet extends HttpServlet {

    private static final long serialVersionUID = -9001479631867349555L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");

        System.out.println("=================收到请求====================");

        PrintWriter writer = resp.getWriter();
        if (SignUtil.checkSignature(signature,timestamp,nonce)) {
            writer.print(echostr);
        }

        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到post请求");
        doGet(req,resp);
    }
}

































