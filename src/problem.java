import java.util.ArrayList;

public class problem{
    private String titleName;
    private String img;
    private String description;
    private ArrayList testCase = new ArrayList();
    public problem(String titleName, String img, String description){
        this.titleName = titleName;
        this.img = img;
        this.description = description;
    }
    
    public problem(String titleName, String img, String description, ArrayList testCase){
        this.titleName = titleName;
        this.img = img;
        this.description = description;
        this.testCase = testCase;
    }
    
    public void setTitleName(String titleName){
        this.titleName = titleName;
    }
    
    public void setImg(String description){
        this.description = description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public void setTestCase(ArrayList testCase){
        this.testCase = testCase;
    }
    
    public String getTitleName(){
        return titleName;
    }
    
    public String getImg(){
        return img;
    }
    
    public String getDescription(){
        return description;
    }
    
    public ArrayList getTestCase(){
        return testCase;
    }
    
    public String getInput(int id){
        ArrayList tmp = (ArrayList)testCase.get(id);
        return tmp.get(0).toString();
    }
    
    public String getOutput(int id){
        ArrayList tmp = (ArrayList)testCase.get(id);
        return tmp.get(1).toString();
    }
    
}
