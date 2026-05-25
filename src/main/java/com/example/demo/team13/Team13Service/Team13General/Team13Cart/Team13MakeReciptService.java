package com.example.demo.team13.Team13Service.Team13General.Team13Cart;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
@Service
public class Team13MakeReciptService {
//	public HttpServletResponse response;
	
	public void makeXSSF(HttpServletResponse response,String word)throws IOException{			//エクセルファイル生成。
		Workbook workbook_ = new XSSFWorkbook();
		
		Sheet sheet_ = workbook_.createSheet("領収書");
//		以下例示コード
		//createRow()に渡すのはインデックス。
		//1行目なら0、2行目なら1。
		//2行目のB列、つまりB2セルに値がセットされる。
		Row row_ = sheet_.createRow(1);
		Cell cell_ = row_.createCell(CellReference.convertColStringToIndex("B"));
//		セルに値をセット
		cell_.setCellValue(word);
//		不要になったら消すこと！
		
		
		
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
