/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.infsci2560.rss.servlets;

import java.io.IOException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.util.logging.Level;

/**
 *
 * @author kolowitzbj
 */
public class RssServlet extends HttpServlet {
    
    private Logger logger = Logger.getLogger(this.getClass());
	private RequestDispatcher homeJsp;
        
        @Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		homeJsp = context.getRequestDispatcher("/index.jsp");
	}

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, IllegalArgumentException, FeedException {
        logger.debug("Retrieving yahoo news feed");
        URL url = new URL("http://rss.news.yahoo.com/rss/tech");
        SyndFeedInput syndFeedInput = new SyndFeedInput();
        SyndFeed syndFeed = null;
        XmlReader xmlReader = new XmlReader(url);
        syndFeed = syndFeedInput.build(xmlReader);
        logger.debug("Forwarding to home.jsp");
        request.setAttribute("syndFeed", syndFeed);
        homeJsp.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (IllegalArgumentException ex) {
            java.util.logging.Logger.getLogger(RssServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FeedException ex) {
            java.util.logging.Logger.getLogger(RssServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (IllegalArgumentException ex) {
            java.util.logging.Logger.getLogger(RssServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FeedException ex) {
            java.util.logging.Logger.getLogger(RssServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
