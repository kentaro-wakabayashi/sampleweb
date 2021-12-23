/**
 * ログインする
 * @param userName ユーザーネーム
 * @param password パスワード
 * @returns ユーザー情報
 */
let login = () => {
	let jsonString = {
		'userName': $('input[name=userName]').val(),
		'password': $('input[name=password]').val()
	};
	$.ajax({
		type: 'POST',
		url: '/sampleweb/auth/login',
		data: JSON.stringify(jsonString),
		contentType: 'application/json',
		datatype: 'json',
		scriptCharset: 'utf-8'
	})
	.then((result) => {
		let user = JSON.parse(result);
		if(user != null){
		$('#welcomeMsg').text(` -- ようこそ! ${user.userName} さん `);
		$('input[name=userName]').hide().val('');
		$('input[name=password]').hide().val('');
		$('input[name=hdnName]').val(user.userName);
		$('#login').hide();
		$('#logout').show();
		$('#myPage').show();
		} else{
			$('#loginError').dialog('open');
			$('input[name=hdnName]').val('');
		}
	}, () => {
		alert('Error:ajax connection failed.');
	}
	);
};

/**
 * ログアウトする
 * @param なし
 * @returns なし
 */	
let logout = () => {
	$.ajax({
		type:'POST',
		url:'/sampleweb/auth/logout',
		scriptCharset:'utf-8'
	})
	.then(() => {
		alert('ログアウトしました。');
		$('input[name=userName]').show().val('');
		$('input[name=password]').show().val('');
		$('input[name=hdnName]').val('');
		$('#login').show();
		$('#logout').hide();
		$('#myPage').hide();
		location.replace('/sampleweb/');
	}, () => {
		alert('Error:ajax connection failed.');
	}
	);		
};

/**
 * 選択されたカート情報を削除する。
 * @param checkedList:選択されたチェックボックスのリスト、checkedIdList:選択されたチェックボックスの値のリスト
 * @returns なし
 */
let deleteCart = (checkedList, checkedIdList) => {
	$.ajax({
		type: 'POST',
		url: '/sampleweb/cart/delete',
		data: JSON.stringify({'checkedIdList': checkedIdList}),
		contentType: 'application/json',
	})
	.then(() => {
		for (checked of checkedList) {
			$(checked).parent().parent().remove();
		}
		
		let checkList = $('.checkList');
		if (checkList.length == 0) {
			location.replace('/sampleweb/cart/');
		}
		// 合計金額、合計個数の設定
		calcTotal();
		// 削除ボタン非活性
		changeDisable();
	}, () => {
		alert('Error: ajax connection failed.');
	});		
};

/**
 * 合計個数、合計金額を計算する。
 * @param なし
 * @returns なし
 */
let calcTotal = () =>  {
	let subTotalList = $('.subTotal');
	let countList = $('.productCount');
	let totalPrice = 0;
	let totalCount = 0;
	
	$(subTotalList).each((i, subTotal) => {
		totalPrice += parseInt($(subTotal).text());
		totalCount += parseInt($(countList[i]).text());
	});
	
	$('#totalPrice').text(totalPrice);
	$('#totalCount').text(totalCount);
};