package com.kwondev.ch01.utils;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

public class ScriptWriter {

  public static void alert(HttpServletResponse response, String alertMsg)
    throws IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<script>alert");
    out.println("alert('" + alertMsg + "')");
    out.println("</script>");
  }

  public static void alert(
    HttpServletResponse response,
    String alertMsg,
    String _type
  ) throws IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<script>alert");
    out.println("alert('" + alertMsg + "');");
    if (_type == "back") {
      out.println("history.back();");
    } else {
      out.println("location.href='" + _type + "'");
    }
    out.println("</script>");
  }
}
