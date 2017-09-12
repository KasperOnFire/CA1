/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Address;

/**
 *
 * @author Anton
 */
public interface AddressFacadeInterface {
    
    public Address createAddress(Address address);
    
    public Address deleteAddress(String street, String additionalInfo);
    
    public Address updateAddress(Address address);
    
}
