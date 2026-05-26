package com.example.demo.team13.Team13Service.Team13General.Team13Cart;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.example.demo.team13.Team13Controller.Team13General.Team13Cart.Team13CartInfo;
@Service
public class Team13MakeReciptService {
//	public HttpServletResponse response;
	
	public void makeXSSF(HttpServletResponse response,List<Team13CartInfo> cartList)throws IOException{			//エクセルファイル生成。
		Workbook workbook_ = new XSSFWorkbook();
		
		Sheet sheet_ = workbook_.createSheet("領収書");
//		以下例示コード
		//createRow()に渡すのはインデックス。
		//1行目なら0、2行目なら1。
		//2行目のB列、つまりB2セルに値がセットされる。
//		Row row_ = sheet_.createRow(1);
//		Cell cell_ = row_.createCell(CellReference.convertColStringToIndex("B"));
//		セルに値をセット
//		cell_.setCellValue();
//		不要になったら消すこと！
		Row row_title = sheet_.createRow(1);
		Cell cell_title = row_title.createCell(CellReference.convertColStringToIndex("E"));
		cell_title.setCellValue("Bold Official Shop");
		
		Row row_NiceSoul = sheet_.createRow(3);
		Cell cell_NiceSoul = row_NiceSoul.createCell(CellReference.convertColStringToIndex("G"));
		cell_NiceSoul.setCellValue("NiceSoul!!!");
		int i = 3;
		int sumPrice = 0;
		for(Team13CartInfo cartData : cartList) {
			i ++;
			int shohinPrice = cartData.getShohin_price();
			int shohinNum = cartData.getShohin_num();
			Row row_shohin_info = sheet_.createRow(i);
			Cell cell_shohin_nm = row_shohin_info.createCell(CellReference.convertColStringToIndex("C"));
			cell_shohin_nm.setCellValue(cartData.getShohin_nm());
			Cell cell_shohin_price = row_shohin_info.createCell(CellReference.convertColStringToIndex("F"));
			cell_shohin_price.setCellValue(shohinPrice + "円");
			Cell cell_shohin_num = row_shohin_info.createCell(CellReference.convertColStringToIndex("G"));
			cell_shohin_num.setCellValue(shohinNum + "点");
			sumPrice = sumPrice + shohinPrice * shohinNum;
		}
		Row row_sumPrice = sheet_.createRow(8);
		Cell cell_sumPrice_dec = row_sumPrice.createCell(CellReference.convertColStringToIndex("C"));
		cell_sumPrice_dec.setCellValue("合計");
		Cell cell_sumPrice = row_sumPrice.createCell(CellReference.convertColStringToIndex("G"));
		cell_sumPrice.setCellValue(sumPrice + "円");
		Row row_goodbye = sheet_.createRow(10);
		Cell cell_goodbye = row_goodbye.createCell(CellReference.convertColStringToIndex("E"));
		cell_goodbye.setCellValue("またのお買い物をお待ちしております！　ナイスォー！");
		
		//---------------------------------------------------------------------------------------------
		//ダウンロード。
		
		//ファイル名に2バイト文字を使えるように一工夫。
		 response.addHeader(
					"Content-Disposition", 
					"attachment; filename*=UTF-8''" + URLEncoder.encode("領収書.xlsx", StandardCharsets.UTF_8.name()));
			
			ServletOutputStream stream_ = response.getOutputStream();
			workbook_.write(stream_);
			stream_.close();
			
			workbook_.close();
			
		
		//---------------------------------------------------------------------------------------------
		//responseをいじっているので、『return "/index";』みたいなことをしても、ページ移動しません。
		//ページ移動せずダウンロードだけ発生することになるので、この関数の戻り値はvoid。
		
		//最小限のサンプルコードなのでtry catchは無しです。
		
	}
			
}
