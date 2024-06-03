package github.petar1905.views.components.user_list_panel;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.MouseInputListener;

import github.petar1905.models.User;

class UserListMouseListener implements MouseInputListener {
    private UserList parent;

    public UserListMouseListener(UserList parent) {
        this.parent = parent;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            System.out.println(parent.getSelectedValue().getName());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent arg0) {}

    @Override
    public void mouseMoved(MouseEvent arg0) {}
}

class UserList extends JList<User> {
    UserList(User[] users) {
        super();
        DefaultListModel<User> listModel = new DefaultListModel<>();
        for (User user : users) {
            listModel.addElement(user);
        }
        this.setModel(listModel);
        UserListMouseListener listener = new UserListMouseListener(this);
        this.addMouseListener(listener);
    }

}

public class ScrollableUserList extends JPanel {
    public ScrollableUserList(User[] users) {
        super();
        UserList userList = new UserList(users);
        JScrollPane scrollPane = new JScrollPane(userList);
        this.add(scrollPane);
    }
}