import com.mytool.tools.ExcelTool;
import com.mytool.interfaces.ITool;

public class Main {

    public static void main(String[] args) {
        ITool tool = new ExcelTool();
        tool.run();
    }
}
