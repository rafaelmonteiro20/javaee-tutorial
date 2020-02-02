package com.fileupload.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/upload")
public class FileUploadServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 7908187011456392847L;

    private final static Logger LOGGER = Logger.getLogger(FileUploadServlet.class.getCanonicalName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        final String destino = request.getParameter("destino");
        final Part arquivo = request.getPart("arquivo");
        final String nomeArquivo = getFileName(arquivo);

        InputStream conteudo = null;
        OutputStream out = null;
        PrintWriter writer = null;
        
        try {
            out = new FileOutputStream(new File(destino + File.separator + nomeArquivo));
            conteudo = arquivo.getInputStream();
            writer = response.getWriter();

            int read;
            final byte[] bytes = new byte[1024];

            while ((read = conteudo.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            
            writer.println("Novo arquivo " + nomeArquivo + " criado em " + destino);
            LOGGER.log(Level.INFO, "Upload do arquivo {0} no diretório {1}", new Object[]{ nomeArquivo, destino });

        } catch (FileNotFoundException ex) {
            writer.println("<br/> ERROR: " + ex.getMessage());
            LOGGER.log(Level.SEVERE, "Problema durante o upload de arquivo. Error: {0}", new Object[]{ ex.getMessage() });
        } finally {
            if (out != null) {
                out.close();
            }
            if (conteudo != null) {
                conteudo.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
   
}
