package com.vk.todoredis;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import redis.clients.jedis.Jedis;

import java.io.IOException;

@WebServlet(name="add",value="/add")
public class Add extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String taskName = request.getParameter("task-name");
        jedis.rpush("tasks",taskName);
        //System.out.println(taskName+" Added Successfully");
        request.setAttribute("taskName",taskName);
        response.sendRedirect("index.jsp");
    }
}
