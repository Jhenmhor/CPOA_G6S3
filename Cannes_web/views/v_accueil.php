<?php
/*
 * DS PHP
 * Vue page index - page d'accueil
 *
 * Copyright 2016, Eric Dufour
 * http://techfacile.fr
 *
 * Licensed under the MIT license:
 * http://www.opensource.org/licenses/MIT
 *
 */
// En tête de page
?>
<?php require_once(PATH_VIEWS.'header.php');?>

<!--  Zone message d'alerte -->




<?php if(isset($_SESSION['logged']))
{
?>

		
		
		<div id="part">
		
		<style>
		#conteneur1
		{
			display: flex;
			justify-content: space-around;
			background-color : #c8a461;
			margin-bottom: 20px;
		}

		button
		{
			background-color: #141414;
			color: #c8a461;

		}
		
		</style>
		
		<div id="conteneur1">
		
		<div class="element1">
		<h1>Gestion VIP</h1>			
		
		<style>
		body
		{
			background-color : #141414;
		}

		
		
			.dropbtn {
				background-color: #4CAF50;
				color: white;
				padding: 16px;
				font-size: 16px;
				border: none;
				cursor: pointer;
			}

			.dropbtn:hover, .dropbtn:focus {
				background-color: #3e8e41;
			}

			#myInput {
				border-box: box-sizing;
				background-image: url('searchicon.png');
				background-position: 14px 12px;
				background-repeat: no-repeat;
				font-size: 16px;
				padding: 14px 20px 12px 45px;
				border: none;
				border-bottom: 1px solid #ddd;
								
			}

			#myInput:focus {outline: 3px solid #ddd;}

			.dropdown {
				position: relative;
				display: inline-block;
				margin-bottom: 200px;
			}

			.dropdown-content {
				position: absolute;
				background-color: #f6f6f6;
				min-width: 230px;
				overflow: auto;
				border: 1px solid #ddd;
				z-index: 1;
				overflow-y: auto;
				
			}

			.dropdown-content a {
				color: black;
				padding: 12px 16px;
				text-decoration: none;
				display: block;
				
			}
			
			#test
			{
				overflow: auto;
				height:150px;
			}

			.dropdown a:hover {background-color: #ddd}

			.show {display:block;}
		</style>

		<div class="dropdown">
		  <div id="myDropdown" class="dropdown-content">
			<input type="text" placeholder="identifiant/prenom/nom" id="myInput" onkeyup="filterFunction()">
			<div id=test>
		  <?php
			  
		  
		      foreach ($personnevip as $i) {
			?>
			
		    <a href="index.php?page=accueil&idvip=<?=$i->getid()?>" style="display: none;"><?=$i->getid()?> <?=$i->getprenom()?> <?=$i->getnom()?></a>
								
		  <?php
			}
			?>
			</div>
		  </div>
		</div>
		

		<script>
		function filterFunction() {
			var input, filter, ul, li, a, i,nb=0;
			input = document.getElementById("myInput");
			filter = input.value.toUpperCase();
			div = document.getElementById("myDropdown");
			a = div.getElementsByTagName("a");
			
			for (i = 0; i < a.length; i++) {
				
				if ((a[i].innerHTML.toUpperCase().indexOf(filter) > -1)) {
					a[i].style.display = "";
					nb=nb+1;
					
				} else {
					a[i].style.display = "none";
				}
				
				
				
			}
			//document.write(nb);
		}
		</script>
		
		
		
		
		</div>
		
		<div class="element2">
		
		<!--
		
		<img src="<?=$_SESSION['photo']?>" alt="fleur" style="float:right;width:42px;height:42px;">
		
		<table border="1">
			<tr>
				<td><?=$_SESSION['logged']?></td>
			</tr>
			
			<tr>
				<td><?=$_SESSION['nom']?></td>
			</tr>
			
			<tr>
				<td><?=$_SESSION['prenom']?></td>
			</tr>
			
		</table>
		
		-->
						
		</br></br></br></br></br>
		<form method="POST" action="index.php?deconnexion">
			<button id="deco" type="submit"><?= MENU_DECONNEXION ?></button>
		</form>
		
		</br></br>

		<style>
		body {font-family: Arial, Helvetica, sans-serif;}

		/* Extra styles for the cancel button */
		.cancelbtn {
			width: auto;
			padding: 10px 18px;
			background-color: #f44336;
		}

		/* Center the image and position the close button */
		.imgcontainer {
			text-align: center;
			margin: 24px 0 12px 0;
			position: relative;
		}

		img.avatar {
			width: 40%;
			border-radius: 50%;
		}

		.container {
			padding: 16px;
		}

		span.psw {
			float: right;
			padding-top: 16px;
		}

		/* The Modal (background) */
		.modal {
			display: none; /* Hidden by default */
			position: fixed; /* Stay in place */
			z-index: 1; /* Sit on top */
			left: 0;
			top: 0;
			width: 100%; /* Full width */
			height: 100%; /* Full height */
			overflow: auto; /* Enable scroll if needed */
			background-color: rgb(0,0,0); /* Fallback color */
			background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
			padding-top: 60px;
		}

		/* Modal Content/Box */
		.modal-content {
			background-color: #fefefe;
			margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
			border: 1px solid #888;
			width: 80%; /* Could be more or less, depending on screen size */
		}

		/* The Close Button (x) */
		.close {
			position: absolute;
			right: 25px;
			top: 0;
			color: #000;
			font-size: 35px;
			font-weight: bold;
		}

		.close:hover,
		.close:focus {
			color: red;
			cursor: pointer;
		}

		/* Add Zoom Animation */
		.animate {
			-webkit-animation: animatezoom 0.6s;
			animation: animatezoom 0.6s
		}

		@-webkit-keyframes animatezoom {
			from {-webkit-transform: scale(0)} 
			to {-webkit-transform: scale(1)}
		}
			
		@keyframes animatezoom {
			from {transform: scale(0)} 
			to {transform: scale(1)}
		}

		/* Change styles for span and cancel button on extra small screens */
		@media screen and (max-width: 300px) {
			span.psw {
			   display: block;
			   float: none;
			}
			.cancelbtn {
			   width: 100%;
			}
		}
		</style>			
	
		<button onclick="document.getElementById('id04').style.display='block'" style="width:auto;">Ajouter un VIP</button>

		<div id="id04" class="modal">
		  
		  <form class="modal-content animate" action="index.php?page=accueil" method="post">
			<div class="imgcontainer">
			  <span onclick="document.getElementById('id04').style.display='none'" class="close" title="Close Modal">&times;</span>
			</div>

			<div class="container">
			
			<h2> Ajouter un VIP </h2>
				
			<table>
				
			 <tr><td> <label for="uname"><b>Prenom :</b></label> 
			  <input type="text"  name="prenom" required> </td></tr>

			 <tr><td> <label for="uname"><b>Nom :</b></label> 
			  <input type="text"  name="nom" required> </td></tr>	
	
			 <tr><td> <label for="uname"><b>Coefficient d'importance:</b></label> 
			  <input type="text"  name="coefimport" required> </td></tr>

			 <tr><td> <label for="uname"><b>Type :</b></label> 
			  <input type="text"  name="type" required> </td></tr>

			 <tr><td> <label for="uname"><b>Identifiant du compagnon :</b></label> 
			  <input type="text"  name="idcomp" required> </td></tr>

			 <tr><td> <label for="uname"><b>Nationalite :</b></label> 
			  <input type="text"  name="nation" required> </td></tr>	

		   <tr><td><label for="uname">Importer une photo</label>
		   <input   name="imgvip" type="file" class="form-control-file" aria-describedby="fileHelp">
		   <small id="fileHelp" class="form-text text-muted"></small></td></tr>		  
					  
				
			</table>

			<button type="submit">Valider</button>			
			  
			</div>

			<div class="container" style="background-color:#f1f1f1">
			  <button type="button" onclick="document.getElementById('id04').style.display='none'" class="cancelbtn">Annuler</button>

			</div>
		  </form>
		</div>				
		

		<script>
		// Get the modal
		var modal = document.getElementById('id04');

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
		</script>

		
		</div>
		
		</div>
		
		

		
		</div>

		<?php
			if(isset($idvip))
			{
		?>		
		
		<div id="part">
		
	
			<style>
			#conteneur2
			{
				display: flex;
				justify-content: space-around;
				background-color : white;
				margin-bottom: 20px;
			}
			</style>

			<div id="conteneur2">
			
			
			
			
			<div class="element1">
			<h2>Detail VIP</h2>
			
			
			<style>
			table {
				font-family: arial, sans-serif;
				border-collapse: collapse;
				width: 100%;
			}	

			td, th {
				border: 1px solid #dddddd;
				text-align: left;
				padding: 8px;
			}

			th {
				background-color: #dddddd;
			}
			
			</style>
			
			<table>
			   <tr>
				<th>Photo</th><td><img src="<?=$photovip->getlien()?>" alt="fleur" style="float:left;width:100px;height:100px;"></td>
			  </tr>
			
			  <tr>
				<th>Identifiant</th><td><?=$idvip?></td>
			  </tr>

				<tr>
					<th>Prenom</th><td><?=$persvip->getprenom()?></td>
				</tr>
			
				<tr>
					<th>Nom</th><td><?=$persvip->getnom()?></td>
				</tr>
				
				<tr>
					<td>			<form action="index.php?page=accueil&supprvip=<?=$idvip?>" method="post" >
			<button>Supprimer le VIP</button>
			</form></td><td><button onclick="document.getElementById('id05').style.display='block'" style="width:auto;">Modifier le VIP</button></td>
				</tr>
				
				
				
			</table>
			</br>
			
		

		<div id="id05" class="modal">
		  
		  <form class="modal-content animate" action="index.php?page=accueil&idvip=<?=$idvip?>" method="post">
			<div class="imgcontainer">
			  <span onclick="document.getElementById('id05').style.display='none'" class="close" title="Close Modal">&times;</span>
			</div>

			<div class="container">
			
			<h2> Modifier Les informations du VIP <?=$persvip->getprenom()?> <?=$persvip->getnom()?> </h2>
				
			<table>
				
			 <tr><td> <label for="uname"><b>Prenom :</b></label> 
			  <input type="text"  name="prenom" value="<?=$persvip->getprenom()?>" required></td></tr>

			 <tr><td> <label for="uname"><b>Nom :</b></label> 
			  <input type="text"  name="nom" value="<?=$persvip->getnom()?>" required> </td></tr>	
	
			 <tr><td> <label for="uname"><b>Coefficient d'importance:</b></label> 
			  <input type="text"  name="coefimport" value="<?= $infovip->getcoef()?>" required> </td></tr>

			 <tr><td> <label for="uname"><b>Type :</b></label> 
			  <input type="text"  name="type" value="<?= $infovip->gettype()?>" required> </td></tr>

			 <tr><td> <label for="uname"><b>Identifiant du compagnon :</b></label> 
			  <input type="text"  name="idcomp" value="<?= $infovip->getidcomp()?>" required> </td></tr>

			 <tr><td> <label for="uname"><b>Nationalite :</b></label> 
			  <input type="text"  name="nation" value="<?= $infovip->getnationalite()?>" required> </td></tr>	
	 					  
				
			</table>

			<button type="submit">Valider</button>			
			  
			</div>

			<div class="container" style="background-color:#f1f1f1">
			  <button type="button" onclick="document.getElementById('id05').style.display='none'" class="cancelbtn">Annuler</button>

			</div>
		  </form>
		</div>				
		

		<script>
		// Get the modal
		var modal = document.getElementById('id05');

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
		</script>			
			
			
			


			

			
			
			</div>
			

			
			<div class="element2">

			<style>
			* {
			  box-sizing: border-box;
			}

			#myInput2 {
			  background-image: url('searchicon.png');
			  background-position: 10px 12px;
			  background-repeat: no-repeat;
			  width: 100%;
			  font-size: 16px;
			  padding: 12px 20px 12px 40px;
			  border: 1px solid #ddd;
			  margin-bottom: 12px;
			}

			#myUL2 {
			  list-style-type: none;
			  padding: 0;
			  margin: 0;
			}

			#myUL2 li a {
			  border: 1px solid #ddd;
			  margin-top: -1px; /* Prevent double borders */
			  background-color: #f6f6f6;
			  padding: 12px;
			  text-decoration: none;
			  font-size: 18px;
			  color: black;
			  display: block
			}

			#myUL2 li a:hover:not(.header) {
			  background-color: #eee;
			}
			</style>				
			
			
				<h2>Historique des demandes</h2>			

				<input type="text" id="myInput2" onkeyup="myFunction2()" placeholder="IdDem/IdStaff/Catégorie " title="Type in a name">
				<div id=test>
				<ul id="myUL2">
			  <?php
				  foreach ($liaiech as $i) {
				?>
				
				<li><a href="index.php?page=accueil&idvip=<?=$i->getidpers()?>&iddem=<?=$i->getidliaisonvip()?>"><?=$i->getidliaisonvip()?> <?=$i->getidstaff()?> <?=$i->getdenomination()?></a><form action="index.php?page=accueil&idvip=<?=$i->getidpers()?>&supprdemande=<?=$i->getidliaisonvip()?>" method="post"><button style="width:auto;">Supprimer La demande numéro : <?=$i->getidliaisonvip()?></button></form></li>
									
			  <?php
				}
				?>
				</ul>
				</div>

				<script>
				function myFunction2() {
					var input, filter, ul, li, a, i;
					input = document.getElementById("myInput2");
					filter = input.value.toUpperCase();
					ul = document.getElementById("myUL2");
					li = ul.getElementsByTagName("li");
					for (i = 0; i < li.length; i++) {
						a = li[i].getElementsByTagName("a")[0];
						if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
							li[i].style.display = "";
						} else {
							li[i].style.display = "none";

						}
					}
				}
				</script>				
		
				
			
			</div>
			
			<div class="element3">
			<style>
			* {
			  box-sizing: border-box;
			}

			#myInput3 {
			  background-image: url('searchicon.png');
			  background-position: 10px 12px;
			  background-repeat: no-repeat;
			  width: 100%;
			  font-size: 16px;
			  padding: 12px 20px 12px 40px;
			  border: 1px solid #ddd;
			  margin-bottom: 12px;
			}

			#myUL3 {
			  list-style-type: none;
			  padding: 0;
			  margin: 0;
			}

			#myUL3 li a {
			  border: 1px solid #ddd;
			  margin-top: -1px; /* Prevent double borders */
			  background-color: #f6f6f6;
			  padding: 12px;
			  text-decoration: none;
			  font-size: 18px;
			  color: black;
			  display: block
			}

			#myUL3 li a:hover:not(.header) {
			  background-color: #eee;
			}
			</style>				
			
			
				<h2>Nouveau type de demande</h2>			

				<input type="text" id="myInput3" onkeyup="myFunction3()" placeholder="IdCat/Catégorie/Acronyme" title="Type in a name">
				<div id=test>
				<ul id="myUL3">
			  <?php
				  foreach ($ech as $i) {
				?>
				
				<li><a onclick="document.getElementById('id02').style.display='block';test('<?=$i->getid()?>','<?=$i->getdenomination()?>');" ><?=$i->getid()?> <?=$i->getdenomination()?> <?=$i->getacronyme()?></a></li>
									
			  <?php
				}
				?>
				</ul>
				</div>

				<script>
				function myFunction3() {
					var input, filter, ul, li, a, i;
					input = document.getElementById("myInput3");
					filter = input.value.toUpperCase();
					ul = document.getElementById("myUL3");
					li = ul.getElementsByTagName("li");
					for (i = 0; i < li.length; i++) {
						a = li[i].getElementsByTagName("a")[0];
						if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
							li[i].style.display = "";
						} else {
							li[i].style.display = "none";

						}
					}
				}
				</script>			

			
			</div>
			
			<div class="element4">
	
				<style>
				body {font-family: Arial, Helvetica, sans-serif;}

				/* Extra styles for the cancel button */
				.cancelbtn {
					width: auto;
					padding: 10px 18px;
					background-color: #f44336;
				}

				/* Center the image and position the close button */
				.imgcontainer {
					text-align: center;
					margin: 24px 0 12px 0;
					position: relative;
				}

				img.avatar {
					width: 40%;
					border-radius: 50%;
				}

				.container {
					padding: 16px;
				}

				span.psw {
					float: right;
					padding-top: 16px;
				}

				/* The Modal (background) */
				.modal {
					display: none; /* Hidden by default */
					position: fixed; /* Stay in place */
					z-index: 1; /* Sit on top */
					left: 0;
					top: 0;
					width: 100%; /* Full width */
					height: 100%; /* Full height */
					overflow: auto; /* Enable scroll if needed */
					background-color: rgb(0,0,0); /* Fallback color */
					background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
					padding-top: 60px;
				}

				/* Modal Content/Box */
				.modal-content {
					background-color: #fefefe;
					margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
					border: 1px solid #888;
					width: 80%; /* Could be more or less, depending on screen size */
				}

				/* The Close Button (x) */
				.close {
					position: absolute;
					right: 25px;
					top: 0;
					color: #000;
					font-size: 35px;
					font-weight: bold;
				}

				.close:hover,
				.close:focus {
					color: red;
					cursor: pointer;
				}

				/* Add Zoom Animation */
				.animate {
					-webkit-animation: animatezoom 0.6s;
					animation: animatezoom 0.6s
				}

				@-webkit-keyframes animatezoom {
					from {-webkit-transform: scale(0)} 
					to {-webkit-transform: scale(1)}
				}
					
				@keyframes animatezoom {
					from {transform: scale(0)} 
					to {transform: scale(1)}
				}

				/* Change styles for span and cancel button on extra small screens */
				@media screen and (max-width: 300px) {
					span.psw {
					   display: block;
					   float: none;
					}
					.cancelbtn {
					   width: 100%;
					}
				}
				</style>				
												
				</br></br></br></br>
				<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Nouvelle catégorie</button>

				<div id="id01" class="modal">
				  
				  <form class="modal-content animate" action="index.php?page=accueil&idvip=<?=$idvip?>" method="post">
					<div class="imgcontainer">
					  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
					</div>
					<h2> Créer une nouvelle catégorie </h2>
					<div class="container">
					  <label for="uname"><b>Denomination</b></label>
					  <input type="text"  name="denomination" required>

					  <label for="psw"><b>Acronyme</b></label>
					  <input type="text"  name="acronyme" required>
						
					  <button type="submit">Valider</button>

					</div>

					<div class="container" style="background-color:#f1f1f1">
					  <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Annuler</button>

					</div>
				  </form>
				</div>
				
				</br></br></br></br>
				
				<div id="id02" class="modal">
				
				  <form id="myForm" class="modal-content animate" action="index.php?page=accueil&idvip=<?=$idvip?>" method="post">
					<div class="imgcontainer">
					  <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>
					</div>
					
					<h2 id="titretypedem"></h2>
					
					<div class="container">
					  <label for="uname"><b>Details de la demande : </b></label>
					  <input type="text"  name="detaildemande" required>
					  
					   <input type='hidden' id= 'hiddenField' name='nbnd' value='' />
				   				   
					   
					  <button type="submit">Valider</button>

					</div>

					<div class="container" style="background-color:#f1f1f1">
					  <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Annuler</button>
					
					
					</div>
				  </form>
				</div>				
				

				<!-- <button onclick="document.getElementById('id03').style.display='block'" style="width:auto;">Supprimer Une demande</button> -->

				<div id="id03" class="modal">
				  
				  <form class="modal-content animate" action="index.php?page=accueil&idvip=<?=$idvip?>" method="post">
					<div class="imgcontainer">
					  <span onclick="document.getElementById('id03').style.display='none'" class="close" title="Close Modal">&times;</span>
					</div>

					<div class="container">
					  <label for="uname"><b>Identifiant de la demande :</b></label>
					  <input type="text"  name="supprdemande" required>
						
					  <button type="submit">Valider</button>

					</div>

					<div class="container" style="background-color:#f1f1f1">
					  <button type="button" onclick="document.getElementById('id03').style.display='none'" class="cancelbtn">Annuler</button>

					</div>
				  </form>
				</div>				
				

				<script>
				// Get the modal
				var modal = document.getElementById('id01');

				// When the user clicks anywhere outside of the modal, close it
				window.onclick = function(event) {
					if (event.target == modal) {
						modal.style.display = "none";
					}
				}
				</script>
				
				<script>
				// Get the modal
				var modal = document.getElementById('id03');

				// When the user clicks anywhere outside of the modal, close it
				window.onclick = function(event) {
					if (event.target == modal) {
						modal.style.display = "none";
					}
				}
				</script>				
				
				<script>
								// Get the modal
				var modal = document.getElementById('id02');
		
				// When the user clicks anywhere outside of the modal, close it
				window.onclick = function(event) {
					if (event.target == modal) {
						modal.style.display = "none";
					}
				}
				
				function test(val,typedem){
				 document.getElementById('hiddenField').value = val;
				 //document.getElementById('titretypedem').value ="Nouvelle demande de type" + typedem;
				 document.getElementById('titretypedem').innerText="Nouvelle demande de type " + typedem;;
			 
				}
				
				
				
				
				
				
				</script>			
								

				
			</div>
					
			
		
			</div>
		</div>
		
		<?php
		if(isset($iddem))
		{
		?>
		
		<div id="part">
		
			<style>
			#conteneur3
			{
				display: flex;
				justify-content: space-around;
				background-color : #c8a461;
				
			}
			</style>		
		
			<div id="conteneur3">
				<div class="element1">
					<h2>Details de la Demande<h2>
					<p><?=$dem->getdetail()?></p>
					
				</div>
				
				<div class="element2">
				
				
				
				<table border="1">
					
					<tr>
						<th>Photo</th><th>Identifiant</th><th>Prenom</th><th>Nom</th>				
					</tr>
					
					<tr>
						<td><img src="<?=$photostaffdem->getlien()?>" alt="fleur" style="float:right;width:100px;height:100px;"></td><td><?=$persdem->getid()?></td><td><?=$persdem->getprenom()?></td><td><?=$persdem->getnom()?></td>
					</tr>
										
				</table>				
				</div>							
			</div>
		</div>
		
		<?php
		}
		?>
		
		<?php
			}
		?>

	
		
<?php
}
else
{
?>

<style>
body {font-family: Arial, Helvetica, sans-serif;}




/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
button {
    background-color: #c8a461;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.container2 {
    padding: 16px;
}


span.psw {
    float: right;
    padding-top: 16px;
}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 350px; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
    position: absolute;
    right: 25px;
    top: 0;
    color: #000;
    font-size: 35px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: red;
    cursor: pointer;
}


/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
	
}


#Global2 {
	margin-left: auto;
    margin-right: auto
    width: 100px;
    background: #c8a461;
    height: 145px;
    top: 230px;
    z-index: 2;
	position: top;
    text-align: center;
	height: 120px;
}

body
{
 background-color: grey;	
}


</style>



	<form class="modal-content animate"  action="index.php?page=accueil" method="post">
    
	<div id="Global2">
		<img id="ctl00_imgMonCompte" src="profil.png" style="margin-top: 20px; margin-bottom: 8px;" /><br />
		<span id="ctl00_Label1" style="color:White;font-family:Camphor W01 Bold;font-size:12px;">MON<br/>COMPTE</span>
	</div>
	
	
    <div  class="container2">
      <label for="identifiant"><b>Identifiant</b></label>
      <input type="text" placeholder="Entrer votre Identifiant :" name="identifiant" required>

      <label for="mdp"><b>Mot de passe</b></label>
      <input type="password" placeholder="Entrer votre Mot de passe :" name="mdp" required>
       
	  <p style="color:red;"><?= isset($alerteconnexion) ?  $alerteconnexion : "" ?></p>
      <button type="submit">Se connecter</button>
	 </div>

 
</form>


	
<?php
}
?>


<!--  FILMS  -->

<?php

// affichage de la boucle de messages


require_once (PATH_VIEWS . 'footer.php'); 


