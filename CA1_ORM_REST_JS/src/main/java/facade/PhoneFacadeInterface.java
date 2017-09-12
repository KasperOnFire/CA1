/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Phone;


public interface PhoneFacadeInterface {
    
    public Phone createPhone(Phone phone);
    
    public Phone deletePhone(int number);
    
    public Phone updatePhone(Phone phone);
    
}
