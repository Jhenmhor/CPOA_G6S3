<?php
/*
 * DS PHP
 * Vue Entete HTML du site
 *
 * Copyright 2017, Eric Dufour
 * http://techfacile.fr
 *
 * Licensed under the MIT license:
 * http://www.opensource.org/licenses/MIT
 *
 */
?>
<!DOCTYPE html>
<html>
<head>
<title>Cannes_web</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="Language" content="<?= LANG ?>" />
<meta name="viewport"
	content="width=device-width; initial-scale=1; maximum-scale=1; user-scalable=0" />
	
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<!-- En-tête -->
	
	<style>

		header
		{
			background-color: #141414;

		}
	
	</style>
	
	
	<header>
	
	
		<section class="container">
			<div class="row">
			<!--
				<div class="col-md-2 col-sm-2 col-xs-12">
					<img src="<?= PATH_LOGO ?>" alt="<?= LOGO ?>" class="img-circle">
				</div>
				<div class="col-md-10 col-sm-10 col-xs-12">
					<h2><?= TITRE ?></h2>
				</div>
			-->

		<style>

			
			#logo-wrapper {
				background-color: #141414;
				height: 200px;			
				transition: all .1s cubic-bezier(.15,.9,.34,.95);
				transform: translateY(0);
							
				}
				
			#logo-wrapper #logo {
					display: inline-block;

					text-align: center;
					vertical-align: middle;
					width: 200px;
					height: 100%;
					position: relative
					

				}
				
				#logo img.palm {
					display: block;
					margin: 0 auto;
					width: 145px;
					transition: .5s;
					transform: translateY(0);
				}	

				.container
				{
					text-align: center;
					
				}


			
																
		</style>
			
		<div id="logo-wrapper">
			<div class="container">
				<div id="logo">
						<img src="https://cdn-vendor.festival-cannes.com/bundles/fdccorporate/img/header/palme.svg" alt="Festival de Cannes" class="palm" />
					<h1>
						<img width="200" src="https://cdn-vendor.festival-cannes.com/bundles/fdccorporate/img/header/logo178.svg" alt="Festival de Cannes" /></h1>
					<h2>
						<span id="ctl00_lbDate" style="color: #c8a461;text-transform: uppercase;">8-19 mai 2018</span>
					</h2>
				</div>
			</div>
		</div>			

			
			</div>
		</section>
	</header>
	<!-- Menu -->
		<?php include(PATH_VIEWS.'menu.php'); ?>
		<!-- Vue -->
	<section class="container">
		<div class="row">