$(document).ready( function () {
	var numeroFollow = 0;
	var numeroNoFollow = 0;
	var numeroFollowOut = 0;
	var control = false;//Para el boton de las imagenes
	var numImg= 0;
	
	
	$('#url').focus();
	
	
	
	$('#boton').click(function(){
		main($('#url').val());
	});
		
	
	
	$("#url").keypress(function(e) {
		
        if(e.which == 13) {
        	main($('#url').val());
        }
        
    });
	
	
	
	
	
	function comprobacionRel(entrada){
	
			 if(entrada == ''){
				 numeroFollow = numeroFollow +1;
				 $('#numFollow').text(numeroFollow);
				 return '<a style="color:green;">follow</a>'
			 }
			 else{
				 numeroNoFollow = numeroNoFollow +1;
				 $('#numNoFollow').text(numeroNoFollow);
				 return '<a style="color:yellow;">' + entrada + '</a>';
			 }
		 
	}
	
	
	function contarFollowFueraDeLaWeb(data){
		$('#tilUrl').show(500);
		var url = $('#url').val()
		var slug = url.split("/");
		var	dominio = slug[1] + slug[2];
		
		
		$(data.datosHref).each(function(index){
			var link = this.link;
			var array = link.split("/");
			var linkFormateado = array[1] + array[2];
			if(linkFormateado != dominio && this.rel == ''  || linkFormateado != dominio && this.rel.toLowerCase() == 'follow' )  {
				numeroFollowOut = numeroFollowOut +1;
				$('#numFollowOut').text(numeroFollowOut);
				$('#listaHrefNoFollow').append('<li><a class="text-muted">La Url es:</a> &nbsp;<a id="nombre" class="text-primary" href="'+ this.link +'">'+this.link +'</a>&nbsp;<a class="text-muted">y su enlace es:&nbsp;</a><a id="rel">'+ comprobacionRel(this.rel) +'</a></li>');
				$('#listaHrefNoFollow').show(500);
				$('#til4').show(500);
			}
		});
		
	};
	
	
	
	
	function main(url){	
		  $('.preloader').show();
		  $('#til1').hide();
		  $('#til2').hide();
		  $('#til3').hide();
		  $('#titulo').hide();
		  $('#parrafoTitulo').hide();
		  $('#listaMeta').empty();
		  $('#listaHref').empty();
		  $('#filasKeyword').empty();
		  $('#numPalabras').empty()
		  $('#listaHrefNoFollow').empty(); 
		  $('#salidaBuscadorKeyword').empty();
		  $('#tilUrl').hide();
		  $('#listaHrefNoFollow').hide();
		  $('#til4').hide();
		  $('#keyword').hide();
		  $('#tilKeyword').hide();
		  $('#botonLimpiarKeyword').hide();
		  $('#buscarKeyword').val('');
		  $('#tablaBuscar').hide();
		  $('#listaImagenes').empty();
		  $('#tilImagenes').hide();
		  $('#listaImagenes').hide();
		  $('#botonImagenes').hide();
		  $('#textoBotonImagenes').text("Mostrar Imagenes");
		  
		 $.ajax({
		      type: 'POST',
		      url: "/post",
		      data:{ url:url} ,
		      success: function(data) {
		        // Do something with the response
		    	  $('#titulo').text(data.titulo);
		    	  $('#parrafoTitulo').show();
		    	  $('#numPalabras').text(data.numeroPalabras);
		    	  $('#numImagenes').text(data.numeroImagenes);
		    	  numImg=data.numeroImagenes;
		    	  $('.preloader').hide();
		    	  control = false;
		    	  console.log(data);
		    	  contarFollowFueraDeLaWeb(data.datosMeta);
		    	  $(data.datosMeta).each(function(index){
		    		  $('#titulo').show(500);
		    		  $('#til1').show(500);
		    		  $('#til2').show(500);
		    		  $('#parrafoTitulo').show(500);
		    		  $('#listaMeta').show(500);
		    		  $('#listaMeta').append('<li><a class="text-muted">El nombre meta es:</a> &nbsp;<a id="nombre" class="text-primary">'+this.nombre +'</a>&nbsp;<a class="text-muted">y su contenido es:</a><a id="contenido" class="text-success">'+this.contenido+'</a></li>');
		    		  
		    	  });
		    	  
		    	  $(data.datosHref).each(function(){
		    		 $('#til3').show(500);
		    		 $('#listaHref').show(500);
		    		 $('#listaHref').append('<li><a class="text-muted">La Url es:</a> &nbsp;<a id="nombre" class="text-primary" href="'+ this.link +'">'+this.link +'</a>&nbsp;<a class="text-muted">y su enlace es:&nbsp;</a><a id="rel">'+ comprobacionRel(this.rel) +'</a></li>');
		    	  });
		    	  
		    	  contarFollowFueraDeLaWeb(data);
		    	  $(data.keyword).each(function(){
			    		 $('#keyword').show(500);
			    		 $('#tilKeyword').show(500);
			    		 $('#buscarKeyword').focus();
			    		 $('#filasKeyword').append('<tr><td>' + this.keyword + '</td><td>' + this.numero + '</td></tr>');      
		    	  });
		    	  
		    	  $(data.imagenes).each(function(){
		    		  	console.log(this.src);
		    		  	 $('#botonImagenes').show();
			    		 $('#tilImagenes').show(500);
			    		 $('#listaImagenes').show(500);
			    		 $('#listaImagenes').append('<li><a class="text-muted">La imágen es:</a> &nbsp;<a id="l" class="text-primary" href="'+ this.src +'">'+this.src +'</a>&nbsp;<a class="text-muted">y el texto alt es:&nbsp;</a><a id="al" class="text-white">'+ this.alt +'</a><div class="fot" style="width:100px;height:100px;display:none;"><a href="' + this.src + '"><img class="img-fluid" src="' + this.src + '"></a></div></li>');
			    	  });
		    	  
		      },
		      error: function(error) {
		        // Do something with the error
		    	  $('#listaMeta').show(500);
		    	 
		    	  $('#listaMeta').append('<li><a class="text-warning">No se puede conectar con esa ruta</a></li>');
		    	  $('.preloader').hide();
		      }
		  });
	}; //Fin del Main
			
		$('#botonImagenes').click(function(){
				if(control == false){
					control=true;
					for(var i=0;i<numImg; i++){
						$('.fot').eq(i).show();
					}
					
					$('#textoBotonImagenes').text('Ocultar Imagenes');
				}
				else{
					control=false;
					for(var j=0;j<numImg; j++){
						$('.fot').eq(j).hide(500);
					}
					$('#textoBotonImagenes').text('Mostrar Imagenes');
				}
		})
	
	
		
		$('#botonKeyword').click(function(){
			var url = $('#buscarKeyword').val()
			$('#tablaBuscar').show(500);
			
			 $.ajax({
			      type: 'POST',
			      url: '/buscarKeyword',
			      dataType: "json",
			      data: {url: url},
			      success: function(data) {
			    	  $('#buscarKeyword').val('');
			    	  $('#salidaBuscadorKeyword').append('<tr><td>' + data.keyword + '</td><td>' + data.numero + '</td></tr>'); 
			    	  $('#botonLimpiarKeyword').show(500);	      
			      }, 		
			      error: function(error) {
			    	  // Do something with the error
			    	  $('#listaMeta').show(500);
			    	  $('#listaMeta').append('<li><a class="text-warning">No se puede conectar con esa ruta</a></li>');
			      }
	
			 		});
											});
		
		$('#botonLimpiarKeyword').click(function(){
			$('#tablaBuscar').hide();
			$('#salidaBuscadorKeyword').find("td").remove();
			$('#botonLimpiarKeyword').hide(500);
		});
						
	
});