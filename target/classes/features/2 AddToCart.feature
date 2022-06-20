Feature: User ingin menambahkan product ke cart
	Scenario: Melakukan pengujian pada cart 
		Then user checkout produk women
		And user checkout product dress
		Then user checkout product t-shirt
		When user proses checkout