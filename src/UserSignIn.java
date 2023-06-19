public class UserSignIn {
    public String user;
    public String password;
    public boolean loggedIn;

    public UserSignIn(String user, String password){
        this.user = user;
        this.password = password;
        this.loggedIn = true;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String pass){
        this.password = pass;
    }

    public void setLoggedIn(boolean loggedIn){
        this.loggedIn = loggedIn;
    }

    public String getUser(){
        return this.user;
    }
    public String getPassword(){
        return this.password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}