package com.example.library.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.library.R;
import com.example.library.databinding.BookItemsBinding;
import com.example.library.model.BookDetails;

import java.util.ArrayList;
import java.util.List;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryViewHolder> {

    List<BookDetails> bookDetails = new ArrayList<>();
    OnBookStoreCardClickListener listener;

    public LibraryAdapter(OnBookStoreCardClickListener listener) {
        this.listener = listener;
    }

    public void setBooks(List<BookDetails> books) {
        bookDetails = books;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LibraryViewHolder(BookItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder( LibraryViewHolder holder, int position) {
        holder.mBinding.bookStoreCard.setOnClickListener(v -> listener.onBookStoreCardClick(bookDetails.get(position)));
        holder.mBinding.bookName.setText(bookDetails.get(position).bookName);
        holder.mBinding.issueDate.setText(bookDetails.get(position).issueDate);
        holder.mBinding.totalPages.setText(bookDetails.get(position).totalPages);
        holder.mBinding.authorName.setText(bookDetails.get(position).authorName);
        holder.mBinding.bookImage.setImageResource(R.drawable.book1);
    }

    @Override
    public int getItemCount() {
        return bookDetails.size();
    }
}
