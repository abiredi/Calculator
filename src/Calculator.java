import javax.swing.*;
import java.awt.event.*;
class Calculator implements ActionListener{//calculator
    JFrame f;
    JTextField t;
    JButton[] nums = new JButton[10];
    JButton divi,multi,sub, add, bdec, equalto ,delete,clear;//all buttons
    static double a=0,b=0,finaldata=0;
    static int operator=0;
    Calculator()
    {//default constructor
        f=new JFrame("Calculator");
        t=new JTextField();
        for(int i=1;i<10;i++){
            nums[i-1] = new JButton(""+ i);
        }
        nums[9]=new JButton("0");

        divi=new JButton("/");
        multi=new JButton("*");
        sub=new JButton("-");
        add=new JButton("+");
        bdec=new JButton(".");
        equalto=new JButton("=");
        delete=new JButton("Delete");
        clear=new JButton("Clear");

        t.setBounds(30,40,280,30);

        nums[6].setBounds(40,90,50,40);
        nums[7].setBounds(110,90,50,40);
        nums[8].setBounds(180,90,50,40);
        divi.setBounds(250,90,50,40);

        nums[3].setBounds(40,160,50,40);
        nums[4].setBounds(110,160,50,40);
        nums[5].setBounds(180,160,50,40);
        multi.setBounds(250,160,50,40);

        nums[0].setBounds(40,240,50,40);
        nums[1].setBounds(110,240,50,40);
        nums[2].setBounds(180,240,50,40);
        sub.setBounds(250,240,50,40);
        bdec.setBounds(40,310,50,40);
        nums[9].setBounds(110,310,50,40);
        equalto.setBounds(180,310,50,40);
        add.setBounds(250,310,50,40);
        delete.setBounds(60,380,100,40);
        clear.setBounds(180,380,100,40);
        f.add(t);
        f.add(nums[6]);
        f.add(nums[7]);
        f.add(nums[8]);
        f.add(divi);
        f.add(nums[3]);
        f.add(nums[4]);
        f.add(nums[5]);
        f.add(multi);
        f.add(nums[0]);
        f.add(nums[1]);
        f.add(nums[2]);
        f.add(sub);
        f.add(bdec);
        f.add(nums[9]);
        f.add(equalto);
        f.add(add);
        f.add(delete);
        f.add(clear);
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(350,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        for(int i=0;i<10;i++){
            nums[i].addActionListener(this);
        }
        add.addActionListener(this);
        divi.addActionListener(this);
        multi.addActionListener(this);
        sub.addActionListener(this);
        bdec.addActionListener(this);
        equalto.addActionListener(this);
        delete.addActionListener(this);
        clear.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        for(int i=1;i<10;i++){
            if(e.getSource()==nums[i-1])
                t.setText(t.getText().concat(""+i));
        }
        if(e.getSource()==nums[9])
            t.setText(t.getText().concat("0"));
        if(e.getSource()==bdec)
            t.setText(t.getText().concat("."));
        if(e.getSource()==add){
            a=Double.parseDouble(t.getText());
            operator=1;
            t.setText("");
        }
        if(e.getSource()==sub){
            a=Double.parseDouble(t.getText());
            operator=2;
            t.setText("");
        }
        if(e.getSource()==multi){
            a=Double.parseDouble(t.getText());
            operator=3;
            t.setText("");
        }
        if(e.getSource()==divi){
            a=Double.parseDouble(t.getText());
            operator=4;
            t.setText("");
        }
        if(e.getSource()==equalto)
        {
            b=Double.parseDouble(t.getText());

            if(operator==1){
                finaldata=a+b;
            } else if (operator==2) {
                finaldata=a-b;
            } else if (operator==3) {
                finaldata=a*b;
            } else if (operator==4) {
                finaldata=a/b;
            } else {
                finaldata=0;
            }
            t.setText(""+finaldata);
        }
        if(e.getSource()==clear)
            t.setText("");
        if(e.getSource()==delete)
        {
            String s=t.getText();
            t.setText("");
            for(int i=0;i<s.length()-1;i++)
                t.setText(t.getText()+s.charAt(i));
        }
    }
    public static void main(String...s){

        new Calculator();
    }}
