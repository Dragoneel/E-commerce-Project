$('.prodinfo')
	.bind('dragstart', function (evt) {
		evt.dataTransfer.setData('text', this.id);
		$('h2').fadeIn('fast');
	})
	.hover(
		function () { $('div', this).fadeIn(); }, 
		function () { $('div', this).fadeOut(); }
	);
	
$('#favorites')
	.bind('dragover', function (evt) {
		$('#favorites').css('background-color','#dedede');
		evt.preventDefault();
	})
	.bind('dragleave', function (evt) {
		$('#favorites').css('background-color','#dedede');
		evt.preventDefault();
	})
	.bind('dragenter', function (evt) {
		evt.preventDefault();
	})
	.bind('drop', function (evt) {
		var id = evt.dataTransfer.getData('text'),
			item = $('#' + id),
			favList = $("#faves"),
			prevFavItem = null;
			prevFavItem = $('<li />', {
				text : $('p:first', item).text(),
				data : { id : id }
			}).appendTo(favList);
		$('#favorites').css('background-color','#fff');
		evt.stopPropagation();
		return false;
	});
