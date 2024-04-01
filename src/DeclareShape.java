public abstract class DeclareShape extends ActionShape{
    protected boolean isNewVar;
    protected String varName;

    public boolean isNewVar() {
        return isNewVar;
    }

    public void setNewVar(boolean status) {
        isNewVar = status;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }
}
