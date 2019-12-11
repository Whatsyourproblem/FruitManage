package com.pdsu.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import com.pdsu.bean.Fruit;
import com.pdsu.dao.IAddFruit;
import com.pdsu.dao.ISelectFruit;
import com.pdsu.daoimpl.AddFruit;
import com.pdsu.daoimpl.SelectFruit;
import com.pdsu.util.Clear;

public class FruitManage extends JFrame{	
	
	IAddFruit addFruit = new AddFruit();
	ISelectFruit selectFruit = new SelectFruit();
	
	
	private JLabel imglabel;
	private JLabel kuanglabel;
	
	private JButton addButton;
	private JButton selectButton;
	private JButton quitButton;
	
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel priceLabel;
	private JLabel unitLabel;
	private JLabel typeLabel;
	
	private JTextField idText;
	private JTextField nameText;
	private JTextField priceText;
	private JComboBox jComboBox;
	
	private JCheckBox jCheckBox1;
	private JCheckBox jCheckBox2;
	private JCheckBox jCheckBox3;
	private JButton jButton1;
	private JPanel panel1;
	
    private TableModel tm;
    private JTable table;
    private JScrollPane jScrollPane;
    private JButton jButton2;
    private JPanel panel2;

    private JPanel buttonPanel;
    
	private JLayeredPane layeredPane = new JLayeredPane();
	
	public static String string;
	
	
	public void load() {
		this.setTitle();
		this.setButton();
		this.setKuang();
		this.setButtonListener();
		this.setFrame();
	}
	
	private void setFrame() {
		this.setBounds(500,175,1000,630);
		this.setLayeredPane(layeredPane);
		this.setUndecorated(true);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void setTitle() {
		ImageIcon icon = new ImageIcon("img/title.png");
		icon.setImage(icon.getImage().getScaledInstance(1000,150, Image.SCALE_DEFAULT ));
		imglabel = new JLabel(icon);
		imglabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
		layeredPane.add(imglabel,JLayeredPane.DEFAULT_LAYER);
	}
	
	
	private void setKuang() {		
		kuanglabel = new JLabel("欢迎使用水果管理系统");
		kuanglabel.setFont(new Font("宋体", Font.PLAIN,45));
		kuanglabel.setBounds(375,125,500,150);
		layeredPane.add(kuanglabel,JLayeredPane.MODAL_LAYER);
	}
	
	
	private void setButton() {		
		addButton = new JButton("添加水果");
		addButton.setFont(new Font("宋体", Font.PLAIN,32));
		addButton.setContentAreaFilled(false);
		addButton.setBounds(0,150,200,90);
		layeredPane.add(addButton,JLayeredPane.MODAL_LAYER);
		
		selectButton = new JButton("查看水果");
		selectButton.setBounds(0, 240,200,90);
		selectButton.setFont(new Font("宋体", Font.PLAIN,32));
		selectButton.setContentAreaFilled(false);
		layeredPane.add(selectButton,JLayeredPane.MODAL_LAYER);
		
		
		quitButton = new JButton("退出程序");
		quitButton.setBounds(0, 330, 200,90);
		quitButton.setFont(new Font("宋体", Font.PLAIN,32));
		quitButton.setContentAreaFilled(false);
		layeredPane.add(quitButton,JLayeredPane.MODAL_LAYER);
	}
	
	private void setAddListener() {
		kuanglabel.setVisible(false);
		panel1 = new JPanel();
		panel1.setLayout(null);

		if(panel2 != null) {
			layeredPane.remove(panel2);
		}
		
		
		idLabel = new JLabel("编号:");
		idLabel.setFont(new Font("宋体", Font.PLAIN,32));
		idLabel.setBounds(75,15, 200, 100);
		//layeredPane.add(idLabel,JLayeredPane.MODAL_LAYER);
		panel1.add(idLabel);
		
		idText = new JTextField();
		idText.setFont(new Font("宋体", Font.PLAIN,32));
		idText.setBounds(175,40,200,50);
		idText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int temp = e.getKeyChar();
                if(temp < 48 || temp > 57){
                    e.consume();
                }
            }
		});
		//layeredPane.add(idText,JLayeredPane.MODAL_LAYER);
		panel1.add(idText);
		
		nameLabel = new JLabel("名称:");
		nameLabel.setFont(new Font("宋体", Font.PLAIN,32));
		nameLabel.setBounds(425,15,200, 100);
		//layeredPane.add(nameLabel,JLayeredPane.MODAL_LAYER);
		panel1.add(nameLabel);
		
		nameText = new JTextField();
		nameText.setFont(new Font("宋体", Font.PLAIN,32));
		nameText.setBounds(525,40,200,50);
		//layeredPane.add(nameText,JLayeredPane.MODAL_LAYER);
		panel1.add(nameText);
		
		priceLabel = new JLabel("单价:");
		priceLabel.setFont(new Font("宋体", Font.PLAIN,32));
		priceLabel.setBounds(75,110,200,100);
		//layeredPane.add(priceLabel,JLayeredPane.MODAL_LAYER);
		panel1.add(priceLabel);
		
		priceText = new JTextField();
		priceText.setFont(new Font("宋体", Font.PLAIN,32));
		priceText.setBounds(175,135, 200, 50);
		//layeredPane.add(priceText,JLayeredPane.MODAL_LAYER);
		priceText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int temp = e.getKeyChar();
                if(temp < 48 || temp > 57){
                    e.consume();
                }
            }
		});
		panel1.add(priceText);
		
		unitLabel = new JLabel("单位:");
		unitLabel.setFont(new Font("宋体", Font.PLAIN,32));
		unitLabel.setBounds(425,110, 200, 100);
		//layeredPane.add(unitLabel,JLayeredPane.MODAL_LAYER);
		panel1.add(unitLabel);
		
		jComboBox = new JComboBox();
		jComboBox.addItem("斤");
		jComboBox.addItem("克");
		jComboBox.addItem("吨");
		jComboBox.setFont(new Font("宋体", Font.PLAIN,32));
		jComboBox.setBounds(525, 135, 200,50);
		//layeredPane.add(jComboBox,JLayeredPane.MODAL_LAYER);
		panel1.add(jComboBox);
		
		typeLabel = new JLabel("类别:");
		typeLabel.setFont(new Font("宋体", Font.PLAIN,32));
		typeLabel.setBounds(75,205, 200, 100);
		//layeredPane.add(typeLabel,JLayeredPane.MODAL_LAYER);
		panel1.add(typeLabel);
		
		jCheckBox1 = new JCheckBox("低温保存");
		jCheckBox1.setFont(new Font("宋体", Font.PLAIN,32));
		jCheckBox1.setBounds(175, 230, 200, 50);
		//layeredPane.add(jCheckBox1,JLayeredPane.MODAL_LAYER);
		panel1.add(jCheckBox1);
		
		jCheckBox2 = new JCheckBox("干燥保存");
		jCheckBox2.setFont(new Font("宋体", Font.PLAIN,32));
		jCheckBox2.setBounds(375,230, 200,50);
		//layeredPane.add(jCheckBox2,JLayeredPane.MODAL_LAYER);
		panel1.add(jCheckBox2);
		
		jCheckBox3 = new JCheckBox("短期保存");
		jCheckBox3.setFont(new Font("宋体", Font.PLAIN,32));
		jCheckBox3.setBounds(575,230, 200,50);
		//layeredPane.add(jCheckBox3,JLayeredPane.MODAL_LAYER);
		panel1.add(jCheckBox3);
		
		jButton1 = new JButton("添加");
		jButton1.setFont(new Font("宋体", Font.PLAIN,32));
		jButton1.setBounds(350,325, 100, 50);
		jButton1.setContentAreaFilled(false);
		jButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idText.getText();
				String name = nameText.getText();
				String price = priceText.getText();
				String unit = (String) jComboBox.getSelectedItem();
				int l = 0;
				String[] s = new String[3];
				String type = "";
				if(jCheckBox1.isSelected()) {
					s[0] = jCheckBox1.getText();
					l++;
				}
				
				if(jCheckBox2.isSelected()) {
					s[1] = jCheckBox2.getText();
					l++;
				}
				
				if(jCheckBox3.isSelected()) {
				    s[2] = jCheckBox3.getText();
				    l++;
				}
				
				for(int i = 0;i < l;i++) {
					if(i == l - 1) {
						type += s[i];
					}else {
						type += s[i] + "&";
					}
				}
				
				if(id.equals("") || name.equals("") || price.equals("") || unit.equals("") || type.equals("")) {
                    JOptionPane.showMessageDialog(null, "请填写完整信息!", "错误", JOptionPane.ERROR_MESSAGE);
				} else{
						Fruit fruit = new Fruit(id,name,price,unit,type);
						try {
							addFruit.addFruit(fruit);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,"添加成功!","提示",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		//layeredPane.add(jButton1,JLayeredPane.MODAL_LAYER);
		panel1.add(jButton1);
		
		panel1.setBounds(200,150,800,480);
		
		layeredPane.add(panel1,JLayeredPane.MODAL_LAYER);
		
	}
	
	private void setSelectListener() throws Exception {
		kuanglabel.setVisible(false);
		panel2 = new JPanel();
		panel2.setLayout(null);
		
		if(panel1 != null) {
			layeredPane.remove(panel1);
		}

	
		List<Fruit> lists = selectFruit.selectFruit();
        if(lists.isEmpty()) {
        	lists.add(new Fruit("","","","",""));
        }
        
		
		createTable(lists);
        
        jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(50,50,700,300);
        //layeredPane.add(jScrollPane,JLayeredPane.MODAL_LAYER);
        panel2.add(jScrollPane);
        
        jButton2 = new JButton("删除");
        jButton2.setFont(new Font("宋体", Font.PLAIN,32));
        jButton2.setContentAreaFilled(false);
        jButton2.setBounds(350,375,100, 50);
        jButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					List<Fruit> list =  selectFruit.selectFruit();
					int flag = 0;
					for(int i = 0;i < list.size();i++) {
						if(list.get(i).getId().equals(string)) {
							flag = i;
							break;
						}
					}
					list.remove(flag);
					
					flushTable(table, list);
					
					Clear.clear();
					
					for (Fruit fruit : list) {
						addFruit.addFruit(fruit);
					}
				
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
        //layeredPane.add(jButton2,JLayeredPane.MODAL_LAYER);
        panel2.add(jButton2);
        panel2.setBounds(200, 150,800,480);
        layeredPane.add(panel2,JLayeredPane.MODAL_LAYER);
	}
	
	private JTable createTable(List<Fruit> lists) {
		
		if(!lists.isEmpty()) {
			
			Object[] columnNames = {"水果编号","名称","价格","单位","类别"};
			Object[][] rowdata;
			rowdata = new Object[lists.size()][5];
			for(int i = 0;i < lists.size();i++) {
				rowdata[i][0] = lists.get(i).getId();
				rowdata[i][1] = lists.get(i).getName();
				rowdata[i][2] = lists.get(i).getPrice();
				rowdata[i][3] = lists.get(i).getUnit();
				rowdata[i][4] = lists.get(i).getType();
			}
		
			tm = new DefaultTableModel(rowdata,columnNames);
			table = new JTable(tm);
			
			table.setRowHeight(25); //设置行高
			table.setPreferredScrollableViewportSize(new Dimension(700,300));
			table.setFont(new Font("宋体", Font.PLAIN, 20));//表格字体
			table.setForeground(Color.magenta);//表格字体颜色
	    
			table.getTableHeader().setFont(new Font("宋体", Font.PLAIN, 22)); //设置表头字体
			table.getTableHeader().setForeground(Color.blue);//设置表头字体颜色
			table.getTableHeader().setReorderingAllowed(false); //禁止用户拖动表头使之重新排序
			table.getTableHeader().setResizingAllowed(false);   //禁止用户手动扩大表头
		
			TableColumn tableColumn2 = table.getColumnModel().getColumn(0);
			tableColumn2.setPreferredWidth(30);
			TableColumn tableColumn3 = table.getColumnModel().getColumn(1);
			tableColumn3.setPreferredWidth(20);
			TableColumn tableColumn4 = table.getColumnModel().getColumn(2);
			tableColumn4.setPreferredWidth(20);
			TableColumn tableColumn5 = table.getColumnModel().getColumn(3);
			tableColumn5.setPreferredWidth(20);
			TableColumn tableColumn6 = table.getColumnModel().getColumn(4);
			tableColumn6.setPreferredWidth(210);
        
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row = table.rowAtPoint(e.getPoint());
					DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
					string = (String) tableModel.getValueAt(row,0);
				}
			});
			return table;
		}
		
		return null;
		
		

	}
	
	private void flushTable(JTable table,List<Fruit> list) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();    //获得表格模型
        tableModel.setRowCount(0);  //清空表格中的所有数据,保留表头

        for (int i = 0; i < list.size(); i++) { //更新表格
            tableModel.addRow(new Object[]{
                    list.get(i).getId(),
                    list.get(i).getName(),
                    list.get(i).getPrice(),
                    list.get(i).getUnit(),
                    list.get(i).getType()
            });
        }
	}
	
	
	private void setButtonListener() {
		
		
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setAddListener();
			}
		});
		
		selectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try { 
					setSelectListener();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		quitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
}
