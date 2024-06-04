package com.vk.todoredis;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import redis.clients.jedis.Jedis;

import java.io.IOException;

@WebServlet(name = "del", value = "/del")
public class Del extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String taskdel = request.getParameter("delTask");
        jedis.lrem("tasks", 0, taskdel);
        response.sendRedirect("index.jsp");
    }
}
