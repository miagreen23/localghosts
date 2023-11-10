package org.example.api;

import org.example.cli.Login;
import org.example.client.FailedToGenerateTokenException;
import org.example.client.FailedToLoginException;
import org.example.db.AuthDAO;

import java.sql.SQLException;

public class AuthService {

    private AuthDAO authDao = new AuthDAO();

    public String login (Login login) throws FailedToLoginException, FailedToGenerateTokenException {
        if(authDao.validLogin(login)) {
            try {
                return authDao.generateToken(login.getUsername());
            } catch (SQLException e){
                throw new FailedToGenerateTokenException();
            }
        }
        throw new FailedToLoginException();
    }
}
