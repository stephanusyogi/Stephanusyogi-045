<?php 

include("config.php");

	$judul_pengumuman = $_POST['judul_pengumuman'];
	$isi_pengumuman = $_POST['isi_pengumuman'];

	$sql = "UPDATE pengumuman_masjid SET judul_pengumuman ='$judul_pengumuman', isi_pengumuman ='$isi_pengumuman' WHERE id_pengumuman = 1";
	$query = mysqli_query($db, $sql);

	//apakah query update berhasil?
	if ($query) {
		
	} else {
		// kalau gagal tampilkan pesan
		die("Gagal menyimpan perubahan...");
	}
	
 ?>