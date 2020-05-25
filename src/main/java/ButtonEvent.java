import java.util.EventObject;

public class ButtonEvent extends EventObject {
    private String action;
    
    public ButtonEvent(Object source, String action) {
        super(source);
        
        this.action = action;
    }
    
    public String getAction() {
        return action;
    }
}