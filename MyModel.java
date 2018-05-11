

import javax.swing.AbstractListModel;

public class MyModel extends AbstractListModel {
	private String[] items;

	public MyModel(String[] items) {
		this.items = items;
	}

	@Override
	public Object getElementAt(int index) {
		return items[index];
	}

	@Override
	public int getSize() {
		return items.length;
	}

	public void update() {
		this.fireContentsChanged(this, 0, items.length - 1);
	}
}
