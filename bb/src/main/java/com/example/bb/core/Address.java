package com.example.bb.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	String addressLine1;
	String addressLine2;
	String city;
	String state;
	String country;
	String pinCode;

}
