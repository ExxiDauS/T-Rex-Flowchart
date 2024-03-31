public class Test {
    public static void main(String[] args) {
        FlowchartController mindControlled = new FlowchartController();
        mindControlled.getModel().getOrder().add(new StartShape());
        mindControlled.getModel().getOrder().add(new ProcessShape());
        mindControlled.getModel().getOrder().add(new EndShape());
        mindControlled.runFlowchart();
    }
}
