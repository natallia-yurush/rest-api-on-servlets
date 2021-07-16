package com.vladbudan.app.servlet;

import com.vladbudan.app.model.Pet;
import com.vladbudan.app.service.impl.PetServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/pet")
public class PetServlet extends HttpServlet {

    private PetServiceImpl petService;

    @Override
    public void init() throws ServletException {
        petService = new PetServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getServletPath();

        switch(action) {
            case "/get":
                try {
                    getPet(req, resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "/add":
                try {
                    addPet(req, resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "/delete":
                try {
                    deletePet(req, resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "/update":
                try {
                    updatePet(req, resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                try {
                    listPet(req, resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void getPet(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        petService.getPetById(id);
    }

    private void addPet(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String kind = request.getParameter("kind");

        Pet newPet = new Pet(id, name, kind);
        petService.addPet(newPet);
    }

    private void deletePet(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        petService.deletePet(id);
    }

    private void updatePet(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String kind = request.getParameter("kind");

        Pet updatedPet = new Pet(id, name, kind);
        petService.updatePet(updatedPet);
    }

    private void listPet(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Pet> listPet = petService.getAllPets();
        request.setAttribute("listPet", listPet);
        RequestDispatcher dispatcher =  request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

}
