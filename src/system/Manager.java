package system;

import java.util.HashMap;

/**
 * Created by 63263 on 2016/12/27.
 */
public class Manager {
    public HashMap<String, Member> getMembers() {
        return members;
    }

    public void setMembers(HashMap<String, Member> members) {
        this.members = members;
    }

    private HashMap<String,Member> members;
    public  Manager(){
        members = new HashMap<>();
    }


}
