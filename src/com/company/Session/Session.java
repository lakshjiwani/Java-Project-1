package com.company.Session;

public class Session {

    private String email;
    private String password;
    private int role;
    private boolean isAdmin;
    public static int sessionId = -1;


    public Session(){

    }

    public Session(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public static void setSessionId(int id){
        sessionId = id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    public boolean isAdmin() {
        return isAdmin;
    }


    public static int getSessionId() {
        return sessionId;
    }

    public void destroySession(){
        setEmail(null);
        setPassword(null);
        setRole(0);
        setAdmin(false);
        setSessionId(-1);
    }

    @Override
    public String toString() {
        return "Username: "+getEmail()+" , Password: "+getPassword()+" , Role: "+getRole()+" , isAdmin: "+isAdmin();
    }
}
