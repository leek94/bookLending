package com.example.mysqlConnectTetst.cotroller;

import com.example.mysqlConnectTetst.model.Author;
import com.example.mysqlConnectTetst.model.Book;
import com.example.mysqlConnectTetst.model.Member;
import com.example.mysqlConnectTetst.request.AuthorCreationRequest;
import com.example.mysqlConnectTetst.request.BookCreationRequest;
import com.example.mysqlConnectTetst.request.BookLendRequest;
import com.example.mysqlConnectTetst.request.MemberCreationRequest;
import com.example.mysqlConnectTetst.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/library")
@RequiredArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;
    // TODO : ResponseEntity 사용법 공부

    @GetMapping("/book")
    public ResponseEntity readBooks(@RequestParam(required = false)String isbn) {
        if (isbn == null){
            return ResponseEntity.ok(libraryService.readBooks());
        }
        return ResponseEntity.ok(libraryService.readBook(isbn));
    }
    @GetMapping("/book/{bookId}")
    public ResponseEntity<Book> readBook(@PathVariable Long bookId) {
        return ResponseEntity.ok(libraryService.readBook(bookId));
    }

    @PostMapping("/book")
    public ResponseEntity<Book> createBook(@RequestBody BookCreationRequest request) {
        return ResponseEntity.ok(libraryService.createBook(request));
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<Void> deleteBook (@PathVariable Long bookId) {
        libraryService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/member")
    public ResponseEntity<Member> createMember (@RequestBody MemberCreationRequest request) {
        return ResponseEntity.ok(libraryService.createMember(request));
    }

    @PatchMapping("/member/{memberId}")
    public ResponseEntity<Member> updateMember (@RequestBody MemberCreationRequest request, @PathVariable Long memberId) {
        return ResponseEntity.ok(libraryService.updateMember(memberId, request));
    }

    @PostMapping("/book/lend")
    public ResponseEntity<List<String>> lendABook(@RequestBody BookLendRequest bookLendRequests) {
        return ResponseEntity.ok(libraryService.lendABook(bookLendRequests));
    }

    @PostMapping("/author")
    public ResponseEntity<Author> createAuthor (@RequestBody AuthorCreationRequest request) {
        return ResponseEntity.ok(libraryService.createAuthor(request));
    }
}
