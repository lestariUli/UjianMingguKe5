Feature: User ingin Login ke Automation Practice. Lalu ingin add barang ke cart
	Scenario: Melakukan pengujian pada form login dan Cart
		Given User mengakses url
		And User input email, password dan klik button login
		When User berhasil login
		And User menambahkan produk woman ke cart
		And User menambahkan produk dress ke cart
		And User menambahkan produk tshirt ke cart
		Then User melakukan proses pembayaran