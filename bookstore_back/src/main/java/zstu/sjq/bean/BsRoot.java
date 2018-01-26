package zstu.sjq.bean;

public class BsRoot {
    private Long rId;

    private String rUsername;

    private String rPassword;

    private String rName;

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public String getrUsername() {
        return rUsername;
    }

    public void setrUsername(String rUsername) {
        this.rUsername = rUsername == null ? null : rUsername.trim();
    }

    public String getrPassword() {
        return rPassword;
    }

    public void setrPassword(String rPassword) {
        this.rPassword = rPassword == null ? null : rPassword.trim();
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }
}