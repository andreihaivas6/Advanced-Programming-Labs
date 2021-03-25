import javax.swing.*;
import java.awt.*;

class MyCellRenderer extends JButton implements ListCellRenderer {
    boolean flag = false;

    public MyCellRenderer() {
        setOpaque(true);
    }

    @Override
    public void setBackground(Color color) {
        if(flag) {
            super.setBackground(color);
        }
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean b1, boolean b2) {
        setText(" ");
        flag = true;
        setBackground((Color) value);
        flag = false;
        return this;
    }
}