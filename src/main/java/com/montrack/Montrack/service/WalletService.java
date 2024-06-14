//package com.montrack.Montrack.service;
//
//import com.montrack.Montrack.entity.User;
//import com.montrack.Montrack.entity.Wallet;
//import com.montrack.Montrack.repository.UserRepository;
//import com.montrack.Montrack.repository.WalletRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class WalletService {
//
//    @Autowired
//    private WalletRepository walletRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public Wallet createWallet(Integer userId, Wallet wallet) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new IllegalArgumentException("User not found"));
//        wallet.setUser(user);
//        return walletRepository.save(wallet);
//    }
//
//    public List<Wallet> getWalletsByUser(Integer userId) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new IllegalArgumentException("User not found"));
//        return walletRepository.findByUser(user);
//    }
//
//    public Optional<Wallet> getWalletById(Integer walletId) {
//        return walletRepository.findById(walletId);
//    }
//}
//
