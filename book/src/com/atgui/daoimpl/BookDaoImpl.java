package com.atgui.daoimpl;

import java.util.List;

import com.atgui.dao.BookDao;
import com.atgui.pojo.Book;

public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao {

	@Override
	public int saveBook(Book book) {
		String sql="INSERT INTO t_book(`id`,`name`,`author`,`price`,`sales`,`stock`,`img_path`) "
				+ "VALUES(? , ? , ?, ? , ?, ?, ?);";
		return update(sql,book.getId(),book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),
				book.getStock(),book.getImgPath());
	}

	@Override
	public int deleteBookById(int id) {
		String sql="DELETE FROM t_book WHERE id=?;";
		return update(sql, id);
		
	}

	@Override
	public int updateBook(Book book) {
		//aaa, 88.0, 小张, 20, 1, static/img/logo.gif, 24
		//String sql="UPDATE `t_book` SET `name`, `price`,`author`,`sales`,`stock`,`img_path` WHERE `id` = ?;";
		String sql = "update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id = ?";
		//return update(sql, book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),
		//book.getImgPath(),book.getId());
		return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(),
				book.getImgPath(), book.getId());
	}

	@Override
	public List<Book> queryBooks() {
		String sql ="SELECT * FROM t_book;";
		return QueryForList(sql);
	}

	@Override
	public Book queryBookById(int id) {
		String sql ="SELECT * FROM t_book WHERE id=?";
		return QueryForOne(sql, id);
	}

	/*@Override
	public Integer queryTotal() {
		// TODO Auto-generated method stub
		return null;
	}*/

}
