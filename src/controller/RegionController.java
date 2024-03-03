package controller;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import dao.RegionDAO;
import exception.SearchNotFoundException;
import model.Region;
import views.ViewRegion;

public class RegionController {
    private RegionDAO regionDAO = new RegionDAO();
    private ViewRegion viewRegion = new ViewRegion();
    private Scanner scanner = new Scanner(System.in);

    public void getAll(){
        viewRegion.viewGetAll(regionDAO.getAll());
    }

    public void createNewRegion(){
        try {
            regionDAO.createNewRegion(viewRegion.viewCreateNewRegion());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean checkInputIsNumber(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch (NumberFormatException exception){
            throw new NumberFormatException("Input Must Be Number!");
        }
    }

    public void getById(String id){
        try {
            checkInputIsNumber(id);
            int number = Integer.parseInt(id);
            viewRegion.viewGetById(regionDAO.getById(number));
        }catch (NumberFormatException |
                SearchNotFoundException
                exception) {
            System.out.println(exception.getMessage());
        }
    }

    private boolean isEmpty(String input){
        if(input.isEmpty()){
            throw new NullPointerException("input can't be empty!");
        }
        return true;
    }

    private boolean isNull(String input){
        if(input == null){
            throw new NullPointerException("input can't be null!");
        }
        return true;
    }

    public boolean checkNameRegion(String name){
        boolean checkNumber = Pattern.matches(".*\\d.*", name);
        boolean cehckSymbol = Pattern.compile("[\\p{Punct}]").matcher(name).find();
        if(!checkNumber && !cehckSymbol){
            return true;
        }
        throw new InputMismatchException("Name Is Not Valid!");
    }

    private List<Region> checkSearchByName(String name){
        if(regionDAO.searchByName(name).isEmpty()){
            throw new SearchNotFoundException("Region with name " + name + " not found!");
        }
        return regionDAO.searchByName(name);
    }

    public void searchByName(String name){
        try {
            isEmpty(name);
            isNull(name);
            viewRegion.viewSearchByName(checkSearchByName(name));
        }catch (NullPointerException |
                SearchNotFoundException
                exception){
            System.out.println(exception.getMessage());
        }
    }

    public void updateRegion(){
        List<String> list = viewRegion.viewUpdateRegion();

        String name = list.get(1);
        String id = list.get(0);

        try{
            checkInputIsNumber(id);
            isEmpty(name);
            isNull(name);
            checkNameRegion(name);
            int number = Integer.parseInt(id);
            getById(id);
            regionDAO.updateRegion(name, number);
            System.out.println("\f");
            System.out.println("Region dengan ID " + id + " berhasil diupdate!");
        }catch (InputMismatchException |
                NullPointerException |
                NumberFormatException
                exception){
            System.out.println(exception.getMessage());
        }
    }

    public void deleteRegion(){
        String id = viewRegion.viewDeleteRegion();
        try {
            getById(id);
            checkInputIsNumber(id);
            int number = Integer.parseInt(id);
            regionDAO.deleteRegion(number);
            System.out.println("Region dengan ID " + id + " berhasil dihapus!");
        }catch (SearchNotFoundException |
                NumberFormatException 
                exception){
            System.out.println(exception.getMessage());
        }
    }

    public void menu(){
        System.out.println("Menu Region");
        System.out.println("1. Lihat Semua Region");
        System.out.println("2. Tambah Region");
        System.out.println("3. Lihat Region Berdasarkan ID");
        System.out.println("4. Cari Region Berdasarkan Nama");
        System.out.println("5. Update Region");
        System.out.println("6. Hapus Region");
        System.out.println("7. Keluar");
    }


    public void viewAll(){
        int pilihan = 0;
        String pilih;
        while (pilihan != 7){
            System.out.println('\f');
            menu();
            System.out.print("Pilihan : ");
            pilih = scanner.nextLine();
            System.out.print("\033[H\033[2J");  
            
            try{
                checkInputIsNumber(pilih);
                pilihan = Integer.parseInt(pilih);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            switch (pilihan){
                case 1:
                    getAll();
                    break;
                case 2:
                    createNewRegion();
                    break;
                case 3:
                    System.out.print("Masukan ID Region : ");
                    String id = scanner.nextLine();
                    getById(id);
                    break;
                case 4:
                    System.out.print("Masukan Nama Region : ");
                    String name = scanner.nextLine();
                    searchByName(name);
                    break;
                case 5:
                    updateRegion();
                    break;
                case 6:
                    deleteRegion();
                    break;
                case 7:
                    System.out.println("Terima Kasih!");
                    break;
                default:
                    System.out.println("Pilihan Tidak Tersedia!");
            }
        }
    }

}
