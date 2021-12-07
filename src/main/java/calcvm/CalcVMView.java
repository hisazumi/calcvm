
package calcvm;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Calc VM")
@Route(value = "calcvm")
@RouteAlias(value = "")

public class CalcVMView extends VerticalLayout {
    
    public CalcVMView() {
        // 中置記法入力
        TextField infixExpr = new TextField();
        infixExpr.setWidth("400px");
        Button translateButton = new Button("変換");
        Button generateButton = new Button("生成");
        Button executeButton = new Button("実行");

        // 後置記法出力
        Label postfixOut = new Label();
        translateButton.addClickListener(e -> {
            postfixOut.setText("1 2 + 3 *");
        });

        // スタックマシン命令列
        VerticalLayout vmInsns = new VerticalLayout();
        generateButton.addClickListener(e -> {
            vmInsns.removeAll();
            vmInsns.add(
                new Label("push 1"),
                new Label("push 2"),
                new Label("add"),
                new Label("push 3"),
                new Label("mul"),
                new Label("wrt"),
                new Label("halt")
            );
        });

        // 実行結果
        Label result = new Label();
        executeButton.addClickListener(e -> {
            result.setText("9");
        });
        
        add(
            new HorizontalLayout(infixExpr, translateButton, generateButton, executeButton),
            new H2("後置記法"),
            postfixOut,
            new H2("スタックマシン命令列"),
            vmInsns,
            new H2("実行結果"),
            result
        );
    }
}
